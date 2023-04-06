package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load students data ... only once!

    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima","Patel"));
        theStudents.add(new Student("Mario","Rossi"));
        theStudents.add(new Student("Mary","Smith"));

    }


    // define endpoint for "/studnets" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }


    // define endpoint or "/students/{studentId}" - return stufent at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){ //int studentId must be same as {studentId}

        // just index into the list ... keep it simple for you

        // check the studentId again list size

        if ( (studentId >= theStudents.size()) || (studentId < 0)  ){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);

    }


    // Add an exception handler using @ExceptionHandler

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
