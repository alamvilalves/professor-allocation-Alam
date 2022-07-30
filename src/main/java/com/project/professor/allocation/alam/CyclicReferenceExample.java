package com.project.professor.allocation.alam;

import java.util.ArrayList;
import java.util.List;

public class CyclicReferenceExample {

	public static class Department
	{
		Long id;
		List<Professor> professors;
		
		@Override
		public String toString() {
			return "Department [id=" + id + ", professors=" + professors + "]";
		}		
	}
	
	public static class Professor
	{
		Long id;
		Department department;

		@Override
		public String toString() {
			return "Professor [id=" + id + ", department=" + department + "]";
		}
	}
	
	public static void main(String[] args) {
		Department department = new Department();
		department.id = 1L;
		department.professors = new ArrayList<Professor>();
		
		Professor professor = new Professor();
		professor.id = 1L;
		professor.department = null;
		
		System.out.println(department);
		// Department [id=1, professors=[]]
		
		System.out.println(professor);
		// Professor [id=1, department=null]
		
		department.professors.add(professor);
		professor.department = department;
		
		System.out.println(professor);
		/*
		Exception in thread "main" java.lang.StackOverflowError
			at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:449)
			at java.lang.StringBuilder.append(StringBuilder.java:136)
			at java.lang.StringBuilder.<init>(StringBuilder.java:113)
			at com.project.professor.allocation.CyclicReferenceExample$Professor.toString(CyclicReferenceExample.java:26)
			at java.lang.String.valueOf(String.java:2994)
			at java.lang.StringBuilder.append(StringBuilder.java:131)
			at java.util.AbstractCollection.toString(AbstractCollection.java:462)
			at java.lang.String.valueOf(String.java:2994)
			at java.lang.StringBuilder.append(StringBuilder.java:131)
			at com.project.professor.allocation.CyclicReferenceExample$Department.toString(CyclicReferenceExample.java:15)
			at java.lang.String.valueOf(String.java:2994)
			at java.lang.StringBuilder.append(StringBuilder.java:131)
			at com.project.professor.allocation.CyclicReferenceExample$Professor.toString(CyclicReferenceExample.java:26)
			at java.lang.String.valueOf(String.java:2994)
			at java.lang.StringBuilder.append(StringBuilder.java:131)
			at java.util.AbstractCollection.toString(AbstractCollection.java:462)
			...
		*/
		
		System.out.println(department);
	}
}