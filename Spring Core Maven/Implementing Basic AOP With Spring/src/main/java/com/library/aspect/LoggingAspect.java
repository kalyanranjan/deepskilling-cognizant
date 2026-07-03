package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void logBeforeMethod() {
        System.out.println("LoggingAspect: A Method Is About To Be Executed");
    }

    @After("execution(* com.library.service.*.*(..))")
    public void logAfterMethod() {
        System.out.println("LoggingAspect: A Method Has Finished Executing");
    }
}
