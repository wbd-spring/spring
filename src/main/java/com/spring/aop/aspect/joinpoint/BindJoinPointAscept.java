package com.spring.aop.aspect.joinpoint;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.spring.annotation.NeedTest;
import com.spring.service.impl.TargetWaiter;

/**
 * 绑定连接点方法入参
 * @author jwh
 *
 */
@Aspect
public class BindJoinPointAscept {

	//args()参数绑定
	@Before("target(com.spring.service.impl.TargetWaiter) && args(clientNam,num,..)")
	public void bindJoinPointParams(int num,String clientNam) {
		System.out.println("绑定连接点参数");
		System.out.println("clientNam="+clientNam);
		System.out.println("num="+num);
	}
	
	//this()绑定代理对象
	@Before("this(tw)")
	public void bindProxy(TargetWaiter tw) {
		System.out.println("绑定代理对象.....");
		System.out.println("tw="+tw.getClass().getName());
	}
	
	//@target,@within()可以将目标类的注解对象绑定到通知方法中
	@Before("@within(n)")
	public void bindType(NeedTest n) {
		System.out.println("绑定类注解对象-----");
		System.out.println("n="+n.getClass().getName());
	}
	
	//绑定返回值
	@AfterReturning(value="target(com.spring.service.impl.TargetWaiter)",returning="result")
	public void bindReturnValue(int result) {
		
		System.out.println("绑定返回值-----");
		System.out.println("result="+result);
	}
}
