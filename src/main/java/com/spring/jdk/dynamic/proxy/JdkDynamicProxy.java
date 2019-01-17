package com.spring.jdk.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.spring.service.proxy.PerformanceMonitor;

/**
 * spring aop采用动态代理的方式， 
 * 动态代理有两种方式：1.jdk 实现方式，目标对象必须实现接口，jdk方式必须实现jdk的InvocationHandler接口
 * 2.cglib方式， 不需要提供接口,但是也要实现接口，(MethodInterceptor),CGLIB是通过生成目标类的子类对象
 * 作为代理类，如果一个类没有接口， 才不能采用jdk动态代理， 只能采用CGLIB进行动态代理
 * @author jwh
 *
 */
public class JdkDynamicProxy implements InvocationHandler{

	private Object target; //目标对象
	
	public JdkDynamicProxy(Object target) { //target为目标对象的业务类
		this.target = target;
	}
	
	
	//利用java的反射机制，调用目标对象的方法
	
	/**
	 * proxy为代理对象，可以不用关心
	 * method为被代理目标对象的某个方法，通过他可以发起目标对象方法的反射调用
	 * args 为被代理目标对象的某个方法的入参.
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		//调用监视器的 begin方法
		PerformanceMonitor.begin(target.getClass().getName()+"=="+method.getName());
		//通过反射调用业务类的目标方法
		Object object = method.invoke(target, args);
		
		for(Object o :args) {
		System.out.println(	o.getClass().getName());
		}
		//调用监视器的 end方法
		PerformanceMonitor.end();
		return object;
	}

}
