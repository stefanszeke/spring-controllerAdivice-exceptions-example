package com.example.springcontrolleradvice.exceptions;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
      super(message);
    }
  
}
