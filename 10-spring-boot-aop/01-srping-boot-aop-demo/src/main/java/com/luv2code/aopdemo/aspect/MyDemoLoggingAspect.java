package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

   // @Before("execution(public void addAccount())") // find all addAccount() methods
   // @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")  // find only  com.luv2code.aopdemo.dao.AccountDAO.addAccount() method
   // @Before("execution(public void add*())")  // find all prefix "add*****" methods
   // @Before("execution( void add*())")  // only find return type void with prefix "add*****" methods
   // @Before("execution( * add*())") // find any type with  prefix "add*****" methods
   // @Before("execution( * add*(com.luv2code.aopdemo.Account))")  //method use Account class parameter  // if parameter class , use the full nane
   // @Before("execution( * add*(com.luv2code.aopdemo.Account,..))")  //method use Account class and more parameter
   // @Before("execution( * com.luv2code.aopdemo.dao.*.*(..))") // find the dao package all methods
    @Before("execution( * com.luv2code.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }




}
