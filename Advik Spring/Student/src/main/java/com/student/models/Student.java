package com.student.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String course;
	
	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false)
	private String gender;
}
