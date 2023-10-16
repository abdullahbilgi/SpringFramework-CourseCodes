package com.luv2code.springboot.thymelefdemo.controller;

import com.luv2code.springboot.thymelefdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @RequestMapping(path = "/showStudentForm",
                    method = RequestMethod.GET)
    public String showForm(Model theModel){

        // create a student object
        Student theStudent= new Student();

        // add studnet object to the model
        theModel.addAttribute("student",theStudent);

        // add the list of countries to the model
        theModel.addAttribute("countries",countries);

        // add the list of languages to the list
        theModel.addAttribute("languages",languages);

        // add the list of languages to the list
        theModel.addAttribute("systems",systems);


        return "student-form";
    }

    @RequestMapping(path = "/processStudentForm",
                    method = RequestMethod.POST)
    public String processForm(@ModelAttribute("student") Student theStudent){

        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";

    }

}
