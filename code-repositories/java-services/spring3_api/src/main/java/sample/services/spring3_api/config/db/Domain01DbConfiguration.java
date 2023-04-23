package sample.services.spring3_api.config.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJdbcRepositories(
        basePackages = "sample.services.spring3_api.domain01.data.repository",
        transactionManagerRef = "domain01TransactionManager",
        jdbcOperationsRef = "domain01JdbcOperations")
public class Domain01DbConfiguration {
    @Bean
    @ConfigurationProperties("spring.domain01.datasource")
    public DataSourceProperties domain01DataSourceProperties() {
        return new DataSourceProperties();
    }

    //1-
    @Bean
    @ConfigurationProperties("spring.domain01.datasource.hikari")
    public DataSource domain01DataSource() {
        return domain01DataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public NamedParameterJdbcTemplate domain01NamedParameterJdbcTemplate(
            @Qualifier("domain01DataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate domain01JdbcTemplate(
            @Qualifier("domain01NamedParameterJdbcTemplate") NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return namedParameterJdbcTemplate.getJdbcTemplate();
    }

    //2
    @Bean
    @Primary
    NamedParameterJdbcOperations domain01JdbcOperations(
            @Qualifier("domain01NamedParameterJdbcTemplate") NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        //return new NamedParameterJdbcTemplate(dataSource);123
        //----
        return namedParameterJdbcTemplate;
    }
    //3
    @Bean
    @Primary
    PlatformTransactionManager domain01TransactionManager(@Qualifier("domain01DataSource") DataSource dataSource) {
        return new JdbcTransactionManager(dataSource);
    }
    
}