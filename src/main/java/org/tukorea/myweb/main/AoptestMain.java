package org.tukorea.myweb.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.tukorea.myweb.domain.BoardVO;
import org.tukorea.myweb.persistence.BoardDAO;
import org.tukorea.myweb.service.BoardService;
import org.tukorea.myweb.service.SampleService;

public class AoptestMain {
    private static ApplicationContext ctx = null;
    public static void main(String[] args) throws Exception {

        ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
        SampleService sampleservice = ctx.getBean(SampleService.class);
        String a = "1";
        String b= "2";
        int result = sampleservice.doAdd(a, b);
        System.out.println("integer = "+ result);
    }
}
