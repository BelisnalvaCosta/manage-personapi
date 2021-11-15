package Dio.Santander.managepersonapi.service;

import Dio.Santander.managepersonapi.dto.MessageResponseDTO;
import Dio.Santander.managepersonapi.dto.request.PersonDTO;
import Dio.Santander.managepersonapi.entity.Person;
import Dio.Santander.managepersonapi.mapper.PersonMapper;
import Dio.Santander.managepersonapi.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.graalvm.compiler.nodeinfo.Verbosity.Id;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @Mock
    private PersonMapper personMapper;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testGivenPersonDTOReturnSavedMessage() {
        Person personDTO = createFakeDTO();
        PersonDTO expectedSavedPerson = createFakeEntity();

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson);
        MessageResponseDTO successMessage = personService.createPerson(PersonDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private Person createFakeDTO() {
    }

    private MessageResponseDTO createExpectedMessage(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Create person with ID " + Id)
                .build();
    }

}

    private <S extends T> S any(Class<Person> personClass) {
    }

    private PersonDTO createFakeEntity() {
    }

}
