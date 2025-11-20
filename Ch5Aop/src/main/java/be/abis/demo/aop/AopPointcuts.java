package be.abis.demo.aop;

import org.aspectj.lang.annotation.Pointcut;

public class AopPointcuts {

    @Pointcut("execution(* welcome*(..))")
    public void execWelcome(){}

    @Pointcut("execution(* be.abis.demo.service.*.get*(..))")
    public void execGet(){}

    @Pointcut(
            "execution(* be.abis.demo.service.*.find*(..))")
    public void findThings(){}
}
