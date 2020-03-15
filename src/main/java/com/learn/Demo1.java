package com.learn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo1 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ap = new AnnotationConfigApplicationContext(SpringAOPTest.class);
		Person person = (Person) ap.getBean("person");
		person.run(1);
		person.run(2, "test");
		person.say();
	}
}
