package com.example.springcontrolleradvice.exceptions;

public class StudentAlreadyExistsException extends RuntimeException {
  
    public StudentAlreadyExistsException(String message) {
      super(message);
    }
}
