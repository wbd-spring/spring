package com.spring.annotation;

import java.lang.reflect.Method;

/**
 * 访问注解
 * @author jwh
 *
 */
public class TestAnnotation {

	public static void main(String[] args) {
		
		Class clazz = ForumServiceImpl.class;
		
		Method[] method = clazz.getDeclaredMethods();
		
		for (Method m : method) {
			
			//获取方法上所标注的注解对象
			NeedTest n=	m.getAnnotation(NeedTest.class);
			
			if(n!=null) {
				
				if(n.value()) {
					System.out.println(m.getName()+"需要测试");
				}else {
					System.out.println(m.getName()+"不需要测试");
				}
			}
		}

	}

}
