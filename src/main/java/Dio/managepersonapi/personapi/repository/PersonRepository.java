package Dio.Santander.managepersonapi.repository;

import Dio.Santander.managepersonapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    static void DeleteById(Long id) {
    }
}
