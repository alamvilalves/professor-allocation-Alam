package com.project.professor.allocation.alam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.alam.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	List<Professor> findByNomeContainingIgnoreCase(String nome);
	List<Professor> findByDepartmentId(Long departmentId);
} 

