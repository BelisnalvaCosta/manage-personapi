package Dio.Santander.managepersonapi.service;

import Dio.Santander.managepersonapi.dto.MessageResponseDTO;
import Dio.Santander.managepersonapi.dto.request.PersonDTO;
import Dio.Santander.managepersonapi.entity.Person;
import Dio.Santander.managepersonapi.exception.PersonNotFoundException;
import Dio.Santander.managepersonapi.mapper.PersonMapper;
import Dio.Santander.managepersonapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
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
        return createMessageResponse(savedPerson.getId(), message: "Created person with ID")
    }

    public List<PersonDTO> ListAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
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

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) PersonDTO)
    private final Long id;

    {
        verifyIfExists(id);

        Person PersonToUpdate = PersonMapper.toModel(personDTO);

        Person updatePerson = personRepository.save(PersonToUpdate);
        return createMessageResponse(updatePerson.getId(), "Updated person with ID "));
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
        .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    public void delete(Long id) {
    }
}
