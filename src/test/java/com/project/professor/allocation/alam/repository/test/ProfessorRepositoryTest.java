package com.project.professor.allocation.alam.repository.test;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.alam.entity.Professor;
import com.project.professor.allocation.alam.repository.ProfessorRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class ProfessorRepositoryTest {

	@Autowired
	ProfessorRepository professorRepository;
	
	@Test
	public void findAll() {
		
		//Act
		List<Professor> professors = professorRepository.findAll();

		//Print
		for (Professor professor : professors)
			System.out.println(professor);
	}
	
	@Test
	public void findById() {
		//Act
		Optional<Professor> optionalProfessor = professorRepository.findById(7L);
		Professor professor = optionalProfessor.orElse(null);
		
		//Print
		System.out.println(professor);
	}
	
	@Test
	public void findByNomeContaningIgnoreCase() {
		//Act
		List<Professor> professors = professorRepository.findByNameContainingIgnoreCase("Rafael");
		
		//Print
		//for (Professor professor : professors)
		//	System.out.println(professor);
		professors.forEach(System.out::println);
		
	}
	
	@Test
	public void findByDepartmentId() {
		//Act
		List<Professor> professors = professorRepository.findByDepartmentId(1L);
		

		//Print
		//for (Professor professor : professors)
		//	System.out.println(professor);
		professors.forEach(System.out::println);
	}
	
	@Test
	public void save_create() {
		//Arrange
		Professor professor = new Professor();
		professor.setId(null);
		professor.setName("Patricia Mergulhão");
		professor.setCpf("08565655699");
		professor.setDepartmentId(1L);
		
		//Act
		professor = professorRepository.save(professor);
		
		//Print
		System.out.println(professor);
	}
	
	@Test
	public void save_update() {
		//Arrange
		Professor professor = new Professor();
		professor.setId(7L);
		professor.setName("Patricia Merg");
		professor.setCpf("11122233344");
		professor.setDepartmentId(1L);
		
		//Act
		professor = professorRepository.save(professor);
		
		//Print
		System.out.println(professor);
	}
	
	@Test
	public void deleteById() {
		//Act
		professorRepository.deleteById(8L);
	}
	
	@Test
	public void deleteAll() {
		//Act
		professorRepository.deleteAllInBatch();
	}
	
}
