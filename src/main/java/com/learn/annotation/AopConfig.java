package com.learn.annotation;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@ComponentScan("com.learn")//自动扫描包
@EnableAspectJAutoProxy //表示开启AOP
@Aspect//表示切面
public class AopConfig {
	@Around(value = "@annotation(Action)")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("方法环绕begin...参数：" + Arrays.toString(proceedingJoinPoint.getArgs()));
		try {
			Object ret = proceedingJoinPoint.proceed();
			System.out.println("方法环绕end...结果：" + ret);
			return ret;
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return null;
	}

	@Before(value = "@annotation(Action)")
	public void doBefore(JoinPoint joinPoint) {

		System.out.println("执行方法前 : " + Arrays.toString(joinPoint.getArgs()));
	}

	@After(value = "@annotation(Action)")
	public void after(JoinPoint joinPoint) {
		System.out.println("执行方法后：" + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "@annotation(Action)", returning = "ret")
	public void doAfterReturning(Object ret) {
		System.out.println("方法的返回值 : " + ret);
	}

	@AfterThrowing(pointcut = "@annotation(Action)", throwing = "ex")
	public void AfterThrowing(JoinPoint joinPoint, Throwable ex) {
		System.out.println("方法执行异常 : " + ex);
	}

}
