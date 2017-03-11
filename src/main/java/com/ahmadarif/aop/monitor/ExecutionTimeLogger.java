package com.ahmadarif.aop.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ARIF on 11-Mar-17.
 */
@Aspect
@Component
public class ExecutionTimeLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutionTimeLogger.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping() {}

    @Pointcut("execution(* com..*Controller.*(..))")
    public void methodPointcut() {}

    @Around("requestMapping() && methodPointcut()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        String name = pjp.getSignature().getName();
        try {
            return pjp.proceed();
        } finally {
            LOGGER.info("STOPWATCH: " + (System.currentTimeMillis() - startTime) + "ms - " + name);
        }
    }

}