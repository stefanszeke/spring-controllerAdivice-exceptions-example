package com.example.springcontrolleradvice.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springcontrolleradvice.exceptions.StudentNotFoundException;
import com.example.springcontrolleradvice.model.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(StudentNotFoundException.class)
  public ResponseEntity<?> studentNotFoundException(StudentNotFoundException ex) {
    System.out.println("StudentNotFoundException Handler");
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), ex.getClass().getSimpleName());
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class) // throws when @Valid fails, Jakarta validation
  public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
      List<ObjectError> errors = ex.getBindingResult().getAllErrors();
      String errorMsg = errors.stream()
                              .map(ObjectError::getDefaultMessage)
                              .collect(Collectors.joining(", "));

      ErrorDetails errorDetails = new ErrorDetails(new Date(), errorMsg, ex.getClass().getSimpleName());
      return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }
  

  
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> globalExceptionHandler(Exception ex) {
    System.out.println("Global Exception Handler");
      ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), ex.getClass().getSimpleName());
      return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }




}
