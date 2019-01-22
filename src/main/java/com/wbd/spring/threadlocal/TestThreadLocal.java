package com.wbd.spring.threadlocal;
public class TestThreadLocal {

	private static int var =100;
	
	private static ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return var;
		}
	};
	
	public int getNext() {
		
		local.set(local.get()-1);
		return local.get();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		TestThreadLocal tt = new TestThreadLocal();
		
		TestClient tc = new TestClient(tt);
		tc.start();
		tc.sleep(100);
		TestClient tc2 = new TestClient(tt);
		tc2.start();
	}
	
	
	private static class TestClient  extends Thread{
		
		private TestThreadLocal tt;
		
		public TestClient(TestThreadLocal tt) {
			this.tt=tt;
		}
		
		@Override
		public void run() {
			
			for(int i=0;i<50;i++) {
				System.out.println("当前线程="+Thread.currentThread().getName()+"\t"+"序号="+tt.getNext());
			}
		}
	}

}
