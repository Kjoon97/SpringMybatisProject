package org.tukorea.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.tukorea.myweb.domain.BoardVO;

@Aspect
@Component
public class BoardAspect {
	
//	@Before("execution(* org.tukorea.myweb.persistence.*.read(..) )")
//	public void beforeMethod(JoinPoint jp) {
//
//		System.out.println(" [BeforeMethod] : 메소드 호출 전 //////////////////////////////////////////////");
//		Signature sig = jp.getSignature();
//		System.out.println(" 메소드 이름: " + sig.getName());
//		Object[] obj = jp.getArgs();
//		System.out.println(" 인수 값: " + obj[0]);
//	}

	@Before("execution(* readBoard(int))")
	public void afterMethod() {
		 System.out.println("---------------before매서드 동작--------------");
	}
	
	@Before("execution(* deleteBoard(int))")
	public void Beforedelete() {
		 System.out.println("---------------before매서드 동작--------------");
	}

}
