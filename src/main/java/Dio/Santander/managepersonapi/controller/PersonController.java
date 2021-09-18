package Dio.Santander.managepersonapi.controller;

import Dio.Santander.managepersonapi.dto.MessageResponseDTO;
import Dio.Santander.managepersonapi.dto.request.PersonDTO;
import Dio.Santander.managepersonapi.entity.Person;
import Dio.Santander.managepersonapi.exception.PersonNotFoundException;
import Dio.Santander.managepersonapi.repository.PersonRepository;
import Dio.Santander.managepersonapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> ListAll() {
        List<PersonDTO> personDTOS = PersonService.ListAll();
        return personDTOS;
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return PersonService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}
