package com.se.eportfoliojpa.repositories;

import com.se.eportfoliojpa.entities.EPortfolio;
import com.se.eportfoliojpa.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findStudentByName(String name);

    List<Student> findAllByAgeBetween(int min, int max);

    List<Student> findAllByListeningContains(EPortfolio ep);
}
