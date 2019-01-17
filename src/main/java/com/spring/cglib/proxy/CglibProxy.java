package com.spring.cglib.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.spring.service.proxy.PerformanceMonitor;

/**
 * CGLIB，动态代理类， 为了满足一个类没有接口， 但是也要产生代理类， 所以就产生了CGLIB代理
 * JDK动态代理，要求目标类必须实现接口。所以不适合
 * 
 * CGLIB是为一个类创建一个子类，在子类中采用方法拦截的技术，拦截所有父类方法的调用。
 * CGLIB采用动态创建子类的方式生成代理对象， 所以不能对目标类的final或private方法进行代理
 * @author jwh
 *
 */
public class CglibProxy implements MethodInterceptor{
	
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class clazz) {
		enhancer.setSuperclass(clazz);//设置需要创建子类的类
		enhancer.setCallback(this);
		return enhancer.create(); //通过字节码技术动态创建子类实例
	}

	/**
	 * Object为目标类的实例
	 * Method 为目标类方法的反射对象
	 * arg2为目标类方法的入参
	 * proxy 为代理类的实例
	 * 
	 */
	public Object intercept(Object arg0, Method method, Object[] arg2, MethodProxy proxy) throws Throwable {
		PerformanceMonitor.begin(arg0.getClass().getName()+"=="+method.getName());
		Object result = proxy.invokeSuper(arg0, arg2);//通过代理类调用父类的方法
		PerformanceMonitor.end();
		return result;
	}

}
