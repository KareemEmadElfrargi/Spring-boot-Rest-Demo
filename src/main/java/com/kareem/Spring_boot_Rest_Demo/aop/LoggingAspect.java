package com.kareem.Spring_boot_Rest_Demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.kareem.Spring_boot_Rest_Demo.service.JobService.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String obj = joinPoint.getTarget().toString();
        Object[] args = joinPoint.getArgs();

        StringBuilder argsBuilder = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            argsBuilder.append("Arg ").append(i + 1).append(" :")
                    .append(args[i] != null ? args[i].toString() : null)
                    .append(" | ");
        }
        LOGGER.info(" Method Called: {}", methodName);
        LOGGER.info(" Arguments: {}", argsBuilder);


    }

    @After("execution(* com.kareem.Spring_boot_Rest_Demo.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        LOGGER.info(" Method Executed:", methodName);

    }

    @AfterThrowing("execution(* com.kareem.Spring_boot_Rest_Demo.service.JobService.*(..))")
    public void logMethodCrash(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        LOGGER.info(" Method has some issues:", methodName);

    }

    @AfterReturning("execution(* com.kareem.Spring_boot_Rest_Demo.service.JobService.*(..))")
    public void logMethodExecutedSuccess(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        LOGGER.info(" Method Executed Successully", methodName);

    }
}
