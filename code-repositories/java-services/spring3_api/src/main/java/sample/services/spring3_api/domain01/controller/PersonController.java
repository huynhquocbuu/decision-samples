package sample.services.spring3_api.domain01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.services.spring3_api.domain01.data.entity.Person;
import sample.services.spring3_api.domain01.data.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/spring3-api/person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/get-all")
    public ResponseEntity<List<Person>> getAll(){
        var data = personRepository.findAll();

        return new ResponseEntity(data, HttpStatus.OK);
    }
}
