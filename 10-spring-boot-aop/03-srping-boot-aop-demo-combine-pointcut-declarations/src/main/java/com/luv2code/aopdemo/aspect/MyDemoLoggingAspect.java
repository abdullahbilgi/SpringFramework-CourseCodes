package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


    @Pointcut("execution( * com.luv2code.aopdemo.dao.*.*(..))") // find all dao package methods
    private void forDaoPackage(){}

    @Pointcut("execution( * com.luv2code.aopdemo.dao.*.get*(..))") // find all dao package getter methods
    private void getter(){}

    @Pointcut("execution( * com.luv2code.aopdemo.dao.*.set*(..))") // find all dao package setter methods
    private void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())") // include package ... exclude getter/setter
    private void forDaoPackageNoGetterSetter() {}



    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n=====>>> Performing API analytics");
    }



}
