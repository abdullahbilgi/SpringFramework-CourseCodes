package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHamdler {

    // add exception handling code here

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){  //return JSON error for http://localhost:8080/api/students/99999

        //create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMassage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        // retrun ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }


    // Add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlerException(Exception exc){   //return JSON error for http://localhost:8080/api/students/sfgadjdhf

        //create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMassage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        //retrun ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }
}
