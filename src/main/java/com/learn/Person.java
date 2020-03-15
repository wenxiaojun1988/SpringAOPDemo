package com.learn;

import org.springframework.stereotype.Component;

@Component("person")
public class Person {
    public void run() {
        System.out.println("我在run...");
    }

    public String run(int i) {
        System.out.println("我在run" + i + "...");
        return i + "";
    }

    public void run(int i, String a) {
        System.out.println("我在run" + i + "..." + a);
    }

    public void say() {
        System.out.println("我在say...");
    }

}
