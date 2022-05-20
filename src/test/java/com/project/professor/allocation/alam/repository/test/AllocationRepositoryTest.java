package com.project.professor.allocation.alam.repository.test;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.alam.entity.Allocation;
import com.project.professor.allocation.alam.repository.AllocationRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTest {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

    @Autowired
    AllocationRepository allocationRepository;

    @Test
    public void findAll() {
        // Act
    	List<Allocation> allocations = allocationRepository.findAll();
        
        // Print
        
        for (Allocation allocation : allocations) {
        	System.out.println(allocation);   	
        }
    }
    @Test
    public void findById() {
           	
        // Act
    	Optional<Allocation> optionAllocation = allocationRepository.findById(6L); 
    	Allocation allocation = optionAllocation.orElse(null);

        // Print
        System.out.println(allocation);
    }

    @Test
    public void findByProfessorId() {
        // Act
    	List<Allocation> allocations = allocationRepository.findByProfessorId(1L);

        // Print
        for (Allocation allocation : allocations) {
        	System.out.println(allocation);
        }
    }

    @Test
    public void findByCourseId() {
        // Act
    	List<Allocation> allocations = allocationRepository.findByCourseId(1L);

        // Print
    	allocations.forEach(System.out::println);
        
    }

    @Test
    public void save_create() throws ParseException {
    	// Arrange
        Allocation allocation = new Allocation();
        allocation.setId(null);
        allocation.setDay(DayOfWeek.SUNDAY);
        allocation.setStart(sdf.parse("17:00-0300"));
        allocation.setEnd(sdf.parse("18:00-0300"));
        allocation.setProfessorId(1L);
        allocation.setCourseId(1L);

        // Act
        allocation = allocationRepository.save(allocation);

        // Print
        System.out.println(allocation);        
    }

    @Test
    public void save_update() throws ParseException {
        // Arrange
        Allocation allocation = new Allocation();
        allocation.setId(1L);
        allocation.setDay(DayOfWeek.MONDAY);
        allocation.setStart(sdf.parse("10:00-0300"));
        allocation.setEnd(sdf.parse("14:00-0300"));
        allocation.setProfessorId(1L);
        allocation.setCourseId(1L);        

        // Act
        allocation = allocationRepository.save(allocation);
        
        // Print
        System.out.println(allocation);
        
    }

    @Test
    public void deleteById() {
        // Arrange
    	List<Allocation> allocations = allocationRepository.findAll();
    	Long id = 4L;
    	
    	
        // Act
    	for (Allocation allocation : allocations)
    		System.out.println(allocation);
    	
    	allocationRepository.deleteById(id);
    	System.out.println("--");
    	allocations = allocationRepository.findAll();
    	allocations.forEach(System.out::println);
        
    }

    @Test
    public void deleteAll() {
        // Act
        allocationRepository.deleteAllInBatch();
    }
}
