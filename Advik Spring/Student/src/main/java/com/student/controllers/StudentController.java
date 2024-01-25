package com.student.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.student.models.Student;
import com.student.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllUser()
 	{
       return studentService.getAllUser();	  
	}
	
	@PostMapping("")
	public ResponseEntity<?> insertStudent(@RequestBody @Valid Student student)
	{
        return studentService.insertStudent(student);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody @Valid Student student,@PathVariable int id)
	{
       return studentService.updateStudent(student, id);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable int id)
	{
		return studentService.deleteStudent(id);
		
	}
	
}
