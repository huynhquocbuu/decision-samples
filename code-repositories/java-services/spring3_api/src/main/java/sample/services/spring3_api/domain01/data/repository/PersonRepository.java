package sample.services.spring3_api.domain01.data.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import sample.services.spring3_api.domain01.data.entity.Person;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
    List<Person> findByFirstName(String firstName);

    @Modifying
    @Query("UPDATE person SET first_name = :name WHERE id = :id")
    boolean updateByFirstName(@Param("id") Long id, @Param("name") String name);
}
