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
	
	@After("execution(* org.tukorea.myweb.persistence.*.read(..) )")
	public void BeforeModify(JoinPoint jp) {
		 System.out.println("---------------수정 전--------------");
		 Signature sig = jp.getSignature();
		 Object[] obj = jp.getArgs();
		 System.out.println(obj[0]+"번 게시판 수정 예정");
		 System.out.println("-----------------------------------");
	}
	
	@After("execution(* org.tukorea.myweb.persistence.*.readList(..) )")
	public void afterMethod(JoinPoint jp) {
		 System.out.println("---------------게시판 진입--------------");
		 Signature sig = jp.getSignature();
		 System.out.println(" 메소드 이름: " + sig.getName());
		 System.out.println("-----------------------------------");
	}
	
	@Before("execution(* deleteBoard(int))")
	public void Beforedelete(JoinPoint jp) {
		 System.out.println("---------------삭제 전--------------");
		 Signature sig = jp.getSignature();
		 Object[] obj = jp.getArgs();
		 System.out.println(obj[0]+"번 게시판 삭제");
		 System.out.println("-----------------------------------");
	}

}
