package com.watt.chp4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.watt.chp3.Demo332.TTools;

public class Demo413 {

	public static class MyService {
		private Lock lock = new ReentrantLock();
		private Condition condition = lock.newCondition();

		public void await() {
			try {
				lock.lock();
				System.out.println(" await time:" + System.currentTimeMillis());
				condition.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}

		public void signal() {
			try {
				lock.lock();
				System.out.println(" signal time:" + System.currentTimeMillis());
				condition.signal();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}

	}

	public static class MyThread1 extends Thread {
		private MyService myService;

		public MyThread1(MyService myService) {
			this.myService = myService;
		}

		public void run() {
			try {
				myService.await();
			} catch (Exception exception) {

			}
		}
	}

	public static class MyThread2 extends Thread {
		public MyThread2() {
		}

		public void run() {
			try {

				for (int i = 0; i < 100; i++) {
					TTools.threadLocal.set("ThreadB" + (i + 1));
					System.out.println("ThreadB" + TTools.threadLocal.get());
					Thread.sleep(200);
				}
			} catch (Exception exception) {

			}
		}
	}

}
