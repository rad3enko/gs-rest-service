package com.example.restservice.aspect;

import com.example.restservice.Greeting;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GreetingControllerAspect {

    @Around("execution(* com.example.restservice.GreetingController.greeting(..))")
    private Greeting aroundAdvise(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Greeting greeting = (Greeting) proceedingJoinPoint.proceed();
        greeting.setId(greeting.getId() * 10);
        return greeting;
    }
}
