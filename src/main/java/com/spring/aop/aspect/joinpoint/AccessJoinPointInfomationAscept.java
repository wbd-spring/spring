package com.spring.aop.aspect.joinpoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 任何通知可以通过JoinPoint访问连接点的上下文信息，如果是环绕通知则使用
 * ProceedingJoinPoint表示连接点对象，该类是JoinPoint的子接口
 * 访问连接点信息
 * @author jwh
 *
 *在切面中，定义一个环绕通知，
 */
@Aspect
public class AccessJoinPointInfomationAscept {
    //target只能定义到类， 表示类型匹配, 切点表达式可以进行组合， and,||,!
	@Around("execution(* com.spring.service.impl.AnnotationWaiter.greet*(..)) || target(com.spring.service.impl.NavieWaiter)")
	public void joinPorintAccess(ProceedingJoinPoint pjp)throws Throwable{
		System.out.println("start----------");
		Object[] args = pjp.getArgs();
		
		System.out.println("参数=="+args[0]);
		
		System.out.println("类名=="+pjp.getTarget().getClass());
		
		System.out.println("方法=="+pjp.getSignature().getName());

		pjp.proceed(); //通过连接点执行目标对象的方法
		System.out.println("end.....");
	}
}
