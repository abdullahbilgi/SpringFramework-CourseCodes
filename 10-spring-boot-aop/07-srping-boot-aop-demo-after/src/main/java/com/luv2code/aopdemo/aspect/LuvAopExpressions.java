package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
// We only have pointcut no  needed @Component
public class LuvAopExpressions {

    @Pointcut("execution( * com.luv2code.aopdemo.dao.*.*(..))") // find all dao package methods
    public void forDaoPackage(){}

    @Pointcut("execution( * com.luv2code.aopdemo.dao.*.get*(..))") // find all dao package getter methods
    public void getter(){}

    @Pointcut("execution( * com.luv2code.aopdemo.dao.*.set*(..))") // find all dao package setter methods
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())") // include package ... exclude getter/setter
    public void forDaoPackageNoGetterSetter() {}
}
