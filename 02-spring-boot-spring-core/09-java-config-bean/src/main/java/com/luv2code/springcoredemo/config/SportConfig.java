package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aqualitic") //if we want give a bean id this here
    public Coach swimCoach(){ //swimCoach is a deafult bean id
        return new SwimCoach();
    }
}
