package com.example.springcontrolleradvice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcontrolleradvice.model.Student;
import com.example.springcontrolleradvice.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/student")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
    return ResponseEntity.ok(studentService.findStudentById(id));
  }

  @GetMapping("/v2/{id}")
  public ResponseEntity<Student> getStudentById2(@PathVariable Long id) {
    Student student = studentService.findStudentById(id);
    return new ResponseEntity<Student>(student, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
    Student savedStudent = studentService.saveStudent(student);
    return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
  }
  
}
