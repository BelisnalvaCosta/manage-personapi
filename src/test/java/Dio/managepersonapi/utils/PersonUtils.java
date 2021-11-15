package Dio.Santander.managepersonapi.utils;

import Dio.Santander.managepersonapi.dto.request.PersonDTO;
import Dio.Santander.managepersonapi.entity.Person;
import Dio.Santander.managepersonapi.entity.Phone;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {
    private static final String FIRST_NAME = "Belisnalva";
    private static final String LAST_NAME = "Costa";
    private static final String CPF_NUMBER = "860.477.006-00";
    private static final long PERSON = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(1989, 07, 9);

    public static PersonDTO createFakeDTO() {
        return Person.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("85-04-1989")
                .phone(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phone(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
