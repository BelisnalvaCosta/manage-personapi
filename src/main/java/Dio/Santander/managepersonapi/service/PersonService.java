package Dio.Santander.managepersonapi.service;

import Dio.Santander.managepersonapi.dto.MessageResponseDTO;
import Dio.Santander.managepersonapi.dto.request.PersonDTO;
import Dio.Santander.managepersonapi.entity.Person;
import Dio.Santander.managepersonapi.exception.PersonNotFoundException;
import Dio.Santander.managepersonapi.mapper.PersonMapper;
import Dio.Santander.managepersonapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;
    
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person PersonToSave = PersonMapper.toModel(personDTO);
                
        Person savedPerson = personRepository.save(PersonToSave);
        return MessageResponseDTO
                .builder()
                .message("created Person with ID " + savedPerson.get.Id())
                .build();
    }
    public List<PersonDTO> ListAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO);
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
       Person person = verifyIfExists(id);

       return personMapper.toDTO(person);
    }

    private void Delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);

        PersonRepository.DeleteById(id);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id);
        .orElseThrow(() -> new PersonNotFoundException(id));
    }

}
