package com.mg.eco.logging;

import com.mg.eco.bussiness.dtos.Message;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
//    @Before("execution(* com.mg.trade.bussiness.services.UserService.insert(..))")
    @Before("@annotation(com.mg.eco.logging.Log)")
    public void before(JoinPoint joinPoint){
        System.out.println("Try To insert User");
    }

//    @AfterReturning(returning = "result",pointcut = "execution(* com.mg.trade.bussiness.services.UserService.insert(..))")
    @AfterReturning(returning = "result",pointcut = "@annotation(com.mg.eco.logging.Log)")
    public void after(JoinPoint joinPoint, Object result){
        Message message = (Message) result;
        String loggingResult = (message.code() == 200)? "successfully insert user": "fail to insert user";
        System.out.println(loggingResult);
    }
}
