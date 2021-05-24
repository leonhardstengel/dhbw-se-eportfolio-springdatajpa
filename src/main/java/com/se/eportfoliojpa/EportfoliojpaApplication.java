package com.se.eportfoliojpa;

import com.se.eportfoliojpa.entities.EPortfolio;
import com.se.eportfoliojpa.entities.Student;
import com.se.eportfoliojpa.repositories.EPortfolioRepository;
import com.se.eportfoliojpa.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class EportfoliojpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EportfoliojpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(StudentRepository studentRepository, EPortfolioRepository ePortfolioRepository){
		return (args) -> {
			Student s1 = new Student("Alex", 19);
			Student s2 = new Student("Anne", 23);
			Student s3 = new Student("Bert", 32);
			Student s4 = new Student("Caro", 32);
			Student s5 = new Student("Thorsten", 32);
			studentRepository.save(s1);
			studentRepository.save(s2);
			studentRepository.save(s3);
			studentRepository.save(s4);
			studentRepository.save(s5);

			EPortfolio p1 = new EPortfolio("Spring Data JPA", s1, List.of(s2, s3), new Date(System.currentTimeMillis()));
			EPortfolio p2 = new EPortfolio("Irgendwas Anderes", s4, List.of(s5, s1), new Date(System.currentTimeMillis()));
			ePortfolioRepository.save(p1);
			ePortfolioRepository.save(p2);


			System.out.println("findAll:");
			for(EPortfolio p: ePortfolioRepository.findAll()) {
				System.out.println(p.toString());
			}

			System.out.println("\nfindById:");
			System.out.println(studentRepository.findById(1).toString());

			System.out.println("\nfindStudentByName:");
			System.out.println(studentRepository.findStudentByName("Alex").toString());

			System.out.println("\nfindAllByAgeBetween:");
			for(Student s: studentRepository.findAllByAgeBetween(20, 30)) {
				System.out.println(s.toString());
			}

			System.out.println("\nfindAllByListeningContains:");
			for(Student s: studentRepository.findAllByListeningContains(p1)) {
				System.out.println(s.toString());
			}

			System.out.println("\nfindByListenersContains:");
			for(EPortfolio p: ePortfolioRepository.findByListenersContains(s2)) {
				System.out.println(p.toString());
			}

			System.out.println("\nfindByStudentInvolved:");
			for(EPortfolio p: ePortfolioRepository.findByStudentInvolved(s1)) {
				System.out.println(p.toString());
			}
		};
	}
}
