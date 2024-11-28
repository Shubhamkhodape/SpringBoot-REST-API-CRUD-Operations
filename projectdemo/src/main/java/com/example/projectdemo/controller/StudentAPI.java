package com.example.projectdemo.controller;

import java.util.List;

import org.slf4j.helpers.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdemo.entity.Student;
import com.example.projectdemo.repository.StudentRepo;

@RestController
public class StudentAPI {

	
	@Autowired
	StudentRepo studentRepo;
	
	@GetMapping(value = "/students")
	public List<Student> getAllStudents(){
		List<Student> students = studentRepo.findAll();
		
		return students;
	}
	
	@GetMapping(value ="/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = studentRepo.findById(id).get();
		return student;
	}
	
	@PostMapping(value = "/students/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		studentRepo.save(student);
	}
	@PutMapping(value = "/students/update/{id}")
	public Student updateStudents(@PathVariable int id) {
		Student student = studentRepo.findById(id).get();
		student.setName("shubh"); 
		student.setPercentage(75);
		return student;
	}
	
	@DeleteMapping(value = "/students/delete/{id}")
	public void removeStudent(@PathVariable int id) {
		Student student = studentRepo.findById(id).get();
		studentRepo.delete(student);
		
	}
	
	
}
