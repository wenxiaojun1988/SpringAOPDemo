package com.learn.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ap = new AnnotationConfigApplicationContext(AopConfig.class);
		DemoAnnotationService service = ap.getBean(DemoAnnotationService.class);
		service.add();
	}

}
