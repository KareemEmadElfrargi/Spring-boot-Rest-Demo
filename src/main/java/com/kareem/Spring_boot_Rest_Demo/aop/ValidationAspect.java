package com.kareem.Spring_boot_Rest_Demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.kareem.Spring_boot_Rest_Demo.service.JobService.*(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint proceedingJoinPoint, int postId) throws Throwable{

        if (postId<0){
            LOGGER.info("Post id is negative , updating it");
            postId = -postId;
            LOGGER.info("new value : "+postId);

        }
        Object object = proceedingJoinPoint.proceed(new Object[]{postId});
        return object;
    }


}
