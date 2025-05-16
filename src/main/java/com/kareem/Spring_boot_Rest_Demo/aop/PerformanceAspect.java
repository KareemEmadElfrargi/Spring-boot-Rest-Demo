package com.kareem.Spring_boot_Rest_Demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("execution( * com.kareem.Spring_boot_Rest_Demo.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object object = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        LOGGER.info("Time Taken by "+joinPoint.getSignature().getName()+" : "+ (endTime-startTime) + " ms");

        return object;

    }

}
