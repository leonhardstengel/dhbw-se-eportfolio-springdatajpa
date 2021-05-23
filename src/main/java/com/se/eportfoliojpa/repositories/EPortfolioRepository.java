package com.se.eportfoliojpa.repositories;

import com.se.eportfoliojpa.entities.EPortfolio;
import com.se.eportfoliojpa.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EPortfolioRepository extends CrudRepository<EPortfolio, Integer> {
    List<EPortfolio> findByListenersContains(Student student);

    @Query(
            "SELECT p FROM EPortfolio p WHERE p.presenter = ?1"
            + "OR ?1 MEMBER OF p.listeners"
    )
    List<EPortfolio> findByStudentInvolved(Student s);
}
