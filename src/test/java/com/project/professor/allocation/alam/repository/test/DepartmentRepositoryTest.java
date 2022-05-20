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

import com.project.professor.allocation.alam.entity.Department;
import com.project.professor.allocation.alam.repository.DepartmentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTest {
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Test
	public void findAll() {
		//Act
		List<Department> departments = departmentRepository.findAll();
		
		//Print
		departments.forEach(System.out::println);
	}	
	@Test
	public void findById() {
		//Act
		Optional<Department> optionalDepartment = departmentRepository.findById(1L);
		Department department = optionalDepartment.orElse(null);
		
		//Print
		System.out.println(department);
	}
	
	@Test
	public void findByNameContainingIgnoreCase() {
		//Act
		List<Department> departments = departmentRepository.findByNameContainingIgnoreCase("front");
		
		//Print
		for (Department department: departments)
			System.out.println(department);
	}
	
	@Test
	public void save_create() {
		//Arrange
		Department department = new Department();
		department.setId(null);
		department.setName("PosGraduacao");
		
		//Act
		departmentRepository.save(department);
		
		//Print
		System.out.println(department);
	}
	
	@Test
	public void save_update() {
		//Arrange
		Department department = new Department();
		department.setId(4L);
		department.setName("Pos-Graduacao");
		
		//Act
		departmentRepository.save(department);
		
		//Print
		System.out.println(department);
				
	}
	@Test
	public void deleteById() {
		//Act
		departmentRepository.deleteById(4L);
	}
	
	@Test
	public void deleteAll() {
		//Act
		departmentRepository.deleteAllInBatch();
	}
	
}
