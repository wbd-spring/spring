package com.spring.service.proxy;

/**
 * 性能监视器
 * 可以理解为aop的切面
 * @author jwh
 *
 */
public class PerformanceMonitor {

	// Threadlocal 将非线程安全类改造为线程安全类
	private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<MethodPerformance>();
	
	public static void begin(String method) {
		System.out.println("监控开始 monitor....");
		MethodPerformance mp = new MethodPerformance(method);
		performanceRecord.set(mp);
		
	}
	
	public static void end() {
		System.out.println("监控结束 monitor....over");
		MethodPerformance mp = performanceRecord.get();
		mp.printPerformance();
		
	}
}
