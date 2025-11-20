package be.abis.demo.aop;

import be.abis.demo.exception.PersonNotWelcomeException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
//@Aspect
public class MyAspect {
    @Before("execution(public * be.abis.demo.service.*.welcome*(..))")
    public void beforeWelcome(){
        System.out.println("Receptionist stands up:");
    }
    @AfterReturning("AopPointcuts.execWelcome()")
    public void afterWelcomeOK(JoinPoint jp){
        System.out.println("Guest is guided to lounge.");
    }
    @AfterThrowing(pointcut="AopPointcuts.execWelcome()",throwing="exc")
    public void afterNotWelcome(PersonNotWelcomeException exc){
        System.out.println("You are escorted back to the door " +exc.getMessage());
    }
    @After("AopPointcuts.execGet()")
    public void afterGetting(JoinPoint jp){
        System.out.println("finished calling getter: " + jp.getSignature().getName());
    }

    @Around("AopPointcuts.findThings()")
    public Object timing(ProceedingJoinPoint pjp){
        Object o =null;
        try {
            long start = System.nanoTime();
            o =  pjp.proceed();
            long end= System.nanoTime();
            System.out.println("time taken by " + pjp.getSignature().getName() +" : " +
                    ((end-start)/1000000.0) + " milliseconds");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return o;
    }
}