package com.example.springcontrolleradvice.service;

import org.springframework.stereotype.Service;

import com.example.springcontrolleradvice.exceptions.StudentAlreadyExistsException;
import com.example.springcontrolleradvice.exceptions.StudentNotFoundException;
import com.example.springcontrolleradvice.model.Student;
import com.example.springcontrolleradvice.repository.StudentRepository;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Student findStudentById(Long id) throws StudentNotFoundException {
    return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found under id: " + id));
  }

  public Student saveStudent(Student student) throws StudentAlreadyExistsException {

    if(studentRepository.existsById(student.getId())) {
      throw new StudentAlreadyExistsException("Student already exists under id: " + student.getId());
    }

    return studentRepository.save(student);
  }
  
}
