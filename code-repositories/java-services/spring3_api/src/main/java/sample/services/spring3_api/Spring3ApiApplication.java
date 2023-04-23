package sample.services.spring3_api;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;
import sample.services.spring3_api.domain01.data.DatabaseSeeder;
import sample.services.spring3_api.domain01.data.entity.Person;
import sample.services.spring3_api.domain01.data.repository.PersonRepository;

@SpringBootApplication
public class Spring3ApiApplication {
//public class Spring3ApiApplication implements CommandLineRunner{
//	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Spring3ApiApplication.class);
//    @Autowired
//    private PersonRepository repository;
//    @Autowired
//    private DatabaseSeeder dbSeeder;
	public static void main(String[] args) {
		SpringApplication.run(Spring3ApiApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		LOGGER.info("@@ Inserting Data....");
//        dbSeeder.insertData();
//        LOGGER.info("@@ findAll() call...");
//        repository.findAll()
//            .forEach(person -> LOGGER.info(person.toString()));
//        LOGGER.info("@@ findById() call...");
//        Optional<Person> optionalPerson = repository.findById(1L);
//        optionalPerson.ifPresent(person -> LOGGER.info(person.toString()));
//        LOGGER.info("@@ save() call...");
//        Person newPerson = new Person("Franz", "Kafka");
//        Person result = repository.save(newPerson);
//        LOGGER.info(result.toString());
//        LOGGER.info("@@ delete");
//        optionalPerson.ifPresent(person -> repository.delete(person));
//        LOGGER.info("@@ findAll() call...");
//        repository.findAll()
//            .forEach(person -> LOGGER.info(person.toString()));
//        LOGGER.info("@@ findByFirstName() call...");
//        repository.findByFirstName("Franz")
//            .forEach(person -> LOGGER.info(person.toString()));
//        LOGGER.info("@@ updateByFirstName() call...");
//        repository.updateByFirstName(2L, "Date Inferno");
//        repository.findAll()
//            .forEach(person -> LOGGER.info(person.toString()));
//	}

}
