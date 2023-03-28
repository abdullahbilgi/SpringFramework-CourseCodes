package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("In consructer: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Pracctice your backend valley";
    }
}
