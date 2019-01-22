package com.wbd.spring.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * spel 动态表达式语言
 * 
 * @author jwh
 *
 */
public class TestSPEL {
	
	public static void main(String[] args) {
		//创建表达式解释器
		ExpressionParser parser = new SpelExpressionParser();
		
		//创建表达式对象
		Expression exp = parser.parseExpression("'hello world'.concat('\t').concat('java')");
		String message = (String) exp.getValue();
		int i = (Integer) parser.parseExpression("6+24").getValue();
		System.out.println(i);
		System.out.println( (Boolean) parser.parseExpression("false").getValue());
		System.out.println( (Boolean) parser.parseExpression("3==3").getValue());
		//支持方法
		System.out.println( (String) parser.parseExpression("'abc'.substring(2)").getValue());
		System.out.println(message);
		
		
	}

}
