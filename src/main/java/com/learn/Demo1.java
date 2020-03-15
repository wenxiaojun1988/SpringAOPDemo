package com.learn;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("application.xml");
        Person person = (Person) ctx.getBean("person");
        person.run(1);
        person.run(1, "test");
        person.say();
    }
}
