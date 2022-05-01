package com.project.professor.allocation.alam.entity;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String nome;
	
	@Column(name = "cpf", nullable = false, unique = true, length = 14)
	private String cpf;
	
	@Column(name = "department_id", nullable = false )
	private Long departmentId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "department_id",nullable = false, insertable = false, updatable = false)
	private Department department;
	
	@OneToMany(mappedBy = "professor")
	private List<Allocation> allocations;
		
		public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<Allocation> getAllocations() {
		return allocations;
	}
	public void setAllocations(List<Allocation> allocations) {
		this.allocations = allocations;
	}
	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", departmentId=" + departmentId
				+ ", department=" + department + "]";
	}	
}
