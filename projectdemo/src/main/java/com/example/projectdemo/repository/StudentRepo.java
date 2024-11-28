package com.example.projectdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectdemo.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
