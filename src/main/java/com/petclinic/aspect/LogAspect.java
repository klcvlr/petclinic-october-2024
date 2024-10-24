package com.petclinic.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class LogAspect {


    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.petclinic..*Service.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        log.info("Log before: Class '{}' method '{}' has been called", className, methodName);
    }

   @Around("execution(* com.petclinic..*Service.*(..))")
   public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
       String methodName = joinPoint.getSignature().getName();
       String className = joinPoint.getTarget().getClass().getName();
       log.info("Log around - before: Class '{}' method '{}' has been called", className, methodName);
       var stopWatch = new StopWatch();

       stopWatch.start();
       var result = joinPoint.proceed();
       stopWatch.stop();

       log.info("Log around - after : Class '{}' method '{}' took {} ms", className, methodName, stopWatch.getTotalTime(TimeUnit.MILLISECONDS));
       return result;
   }
}


