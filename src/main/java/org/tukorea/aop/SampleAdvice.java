package org.tukorea.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
public class SampleAdvice {

    @Before("execution(* doAdd(String,String))")
    public void logBefore(){
        System.out.println("---------------before매서드 동작--------------");
    }
}
