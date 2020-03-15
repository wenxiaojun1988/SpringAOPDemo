package com.learn;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class SpringAOPTest {
    /**
     * 定义切面,拦截方法
     * execution(
     * public : 方法的修饰词(*代表所有)
     * String : 方法的返回值(*代表所有)
     * com.anting..* : 包com.anting和其下面所有子包的所有类(..表示包含子包下的所有类)
     * .run* : 方法名,此处可指定类名以run开头(*run*表示方法名只需要run即可,类似*run)
     * (..) : 接受的参数类型,(..表示所有参数)[(int,*)表示接受参数为2个,其中第一个为int类型,第二个任一]
     * )
     */
    @Pointcut("execution (public * com.anting..*.run*(..))")
    public void pointCutMethod() {
    }

    ;

/*    @Before("pointCutMethod()")
    public void before() {
        System.out.println("method start");
    }

    @After("pointCutMethod()")
    public void after(){
        System.out.println("method end");
    }*/

    @Around("pointCutMethod()")
    public void around(ProceedingJoinPoint joinpoint) throws Throwable {
        //可以先做一些判断
        if (1 == 1) {
            System.out.println("方法条件满足,开始执行方法!");
            joinpoint.proceed();
            System.out.println("执行方法完毕!");
        } else {
            System.out.println("方法条件不满足,直接退出!");
        }
    }
}
