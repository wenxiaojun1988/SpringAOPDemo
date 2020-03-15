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


@ComponentScan("com.learn")//�Զ�ɨ���
@EnableAspectJAutoProxy //��ʾ����AOP
@Aspect//��ʾ����
public class AopConfig {
	@Around(value = "@annotation(Action)")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("��������begin...������" + Arrays.toString(proceedingJoinPoint.getArgs()));
		try {
			Object ret = proceedingJoinPoint.proceed();
			System.out.println("��������end...�����" + ret);
			return ret;
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return null;
	}

	@Before(value = "@annotation(Action)")
	public void doBefore(JoinPoint joinPoint) {

		System.out.println("ִ�з���ǰ : " + Arrays.toString(joinPoint.getArgs()));
	}

	@After(value = "@annotation(Action)")
	public void after(JoinPoint joinPoint) {
		System.out.println("ִ�з�����" + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "@annotation(Action)", returning = "ret")
	public void doAfterReturning(Object ret) {
		System.out.println("�����ķ���ֵ : " + ret);
	}

	@AfterThrowing(pointcut = "@annotation(Action)", throwing = "ex")
	public void AfterThrowing(JoinPoint joinPoint, Throwable ex) {
		System.out.println("����ִ���쳣 : " + ex);
	}

}
