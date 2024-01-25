package com.student.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.student.models.Student;
import com.student.repositories.StudentRepository;
import com.student.responsewrappers.StudentResponseWrapper;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	StudentResponseWrapper srw=new StudentResponseWrapper();

	public ResponseEntity<?> getAllUser()
	{
	  Iterable<Student> data=studentRepository.findAll();
	  Iterator<Student> studentdate=data.iterator();
	  if(!studentdate.hasNext())
	  {
		  throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no Data in Database.");
	  }
	  else
	  {
		  srw.setData(studentdate);
		  srw.setMessage("Student Details");
		  return new ResponseEntity<>(srw,HttpStatus.FOUND);
		  
	  }
	  
	  }
	
	public ResponseEntity<?> insertStudent(Student student)
	{
        Student data=studentRepository.save(student);
        if(data==null)
        {
        	throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"There is Some Internal Issue.");
        }
        else
        {
        	srw.setData(data);
        	srw.setMessage("Data Posted Sucessfully");
        	return new ResponseEntity<>(srw,HttpStatus.CREATED);
        }
		
	}
	
	
	
	public ResponseEntity<?> updateStudent(Student student,int id)
	{
               studentRepository.findById(id).orElseThrow(
    		   ()->{
    			   
    			   throw new ResponseStatusException(HttpStatus.NOT_FOUND," Student with Id "+id+" not founded");
    		   }
    		   );
       student.setId(id);
       Student updateData=studentRepository.save(student);
       srw.setData(updateData);
       srw.setMessage("Student With Id "+id+" updated Sucessfully");
       return new ResponseEntity<>(srw,HttpStatus.ACCEPTED);
		
	}
	
	
	public ResponseEntity<?> deleteStudent(int id)
	{
		studentRepository.findById(id).orElseThrow(
	    		   ()->{
	    			   
	    			   throw new ResponseStatusException(HttpStatus.NOT_FOUND," Student with Id "+id+" not founded");
	    		   }
	    		   );
		
		
		studentRepository.deleteById(id);
		srw.setData(null);
		srw.setMessage("Student with Id "+id+ " Deleted Sucessfully.");
		return new ResponseEntity<>(srw,HttpStatus.OK);
		
	}
	
	
}
