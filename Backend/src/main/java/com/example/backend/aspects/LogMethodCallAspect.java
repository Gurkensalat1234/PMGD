package com.example.backend.aspects;

import org.apache.logging.slf4j.SLF4JLogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogMethodCallAspect {

    private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);

    @Around("@annotation(com.example.backend.annotations.LogMethodCall)")
    public Object catchBusinessExceptions(ProceedingJoinPoint jointPoint) throws Throwable {

        Object target = jointPoint.getTarget();
        System.out.println("HALLO");
        Object proceed = jointPoint.proceed();

        return proceed;
    }

}
