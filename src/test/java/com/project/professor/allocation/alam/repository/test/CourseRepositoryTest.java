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

import com.project.professor.allocation.alam.entity.Course;
import com.project.professor.allocation.alam.repository.CourseRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTest {
	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void findAll() {
		//Act
		List<Course> courses = courseRepository.findAll();
		
		//Print
		courses.forEach(System.out::println);
	}	
	@Test
	public void findById() {
		//Act
		Optional<Course> optionalCourse = courseRepository.findById(1L);
		Course course = optionalCourse.orElse(null);
		
		//Print
		System.out.println(course);
	}
	
	@Test
	public void findByNameContainingIgnoreCase() {
		//Act
		List<Course> courses = courseRepository.findByNameContainingIgnoreCase("front");
		
		//Print
		for (Course course : courses)
			System.out.println(course);
	}
	
	@Test
	public void save_create() {
		//Arrange
		Course course = new Course();
		course.setId(null);
		course.setName("fullstack");
		
		//Act
		courseRepository.save(course);
		
		//Print
		System.out.println(course);
	}
	
	@Test
	public void save_update() {
		//Arrange
		Course course = new Course();
		course.setId(4L);
		course.setName("FullStack2");
		
		//Act
		courseRepository.save(course);
		
		//Print
		System.out.println(course);
				
	}
	@Test
	public void deleteById() {
		//Act
		courseRepository.deleteById(4L);
	}
	
	@Test
	public void deleteAll() {
		//Act
		courseRepository.deleteAllInBatch();
	}
	
}
