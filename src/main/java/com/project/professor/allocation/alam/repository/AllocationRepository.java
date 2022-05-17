package com.project.professor.allocation.alam.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.professor.allocation.alam.entity.Allocation;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {
	
	List<Allocation> findByProfessorId(Long professorId);
	List<Allocation> findByCourseId(Long courseId);

}