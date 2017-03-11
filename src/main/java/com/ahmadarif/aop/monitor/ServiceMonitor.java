package com.ahmadarif.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ARIF on 10-Mar-17.
 */
@Aspect
@Component
public class ServiceMonitor {

    /**
     * NOTE:
     *  - () tanpa param di call
     *  - (..) dengan atau tanpa param di call
     */

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceMonitor.class);

    @AfterReturning("execution(* com..*Service.*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        LOGGER.info("logServiceAccess: " + joinPoint);
    }

    @Before("execution(* com..*Service.*(..))")
    public void logBefore2(JoinPoint joinPoint) {
        LOGGER.info("logBefore2: " + joinPoint);
    }

    @Before("execution(* com..*Service.*())")
    public void logBefore1(JoinPoint joinPoint) {
        LOGGER.info("logBefore1: " + joinPoint);
    }

    @After("execution(* com..*Service.*(..))")
    public void logAfter1(JoinPoint joinPoint) {
        LOGGER.info("logAfter1: " + joinPoint);
    }

    @After("execution(* com..*Service.*(String)) && args(name)")
    public void logAfter2(JoinPoint joinPoint, String name) {
        LOGGER.info("logAfter2: " + name + " - " + joinPoint);
    }

    @Around("execution(* com..*Service.*(String)) && args(name)")
    public void aroundSampleCreation(ProceedingJoinPoint proceedingJoinPoint, String name) throws Throwable {
        LOGGER.info("A request was issued for a sample name: " + name);
        proceedingJoinPoint.proceed(new Object[] {name.toUpperCase()});
    }

}