package com.example.springcontrolleradvice.model;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorDetails {
  private String name = "Custom Error Details";
  private String exception;
  private Date timestamp;
  private String message;

  public ErrorDetails(Date timestamp, String message, String exception) {
    super();
    this.timestamp = timestamp;
    this.message = message;
    this.exception = exception;
  }
}
