package com.watt.chp4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.watt.chp3.Demo332.TTools;

public class Demo418 {

	public static class MyService {
		private Lock lock = new ReentrantLock();
		private Condition condition = lock.newCondition();
		private boolean hasValue = false;

		public void set() {
			try {
				lock.lock();
				if (hasValue) {
					System.out.println("out 111-111");
					condition.await();
				}
				System.out.println("out 111");
				hasValue = true;
				condition.signalAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void get() {
			try {
				lock.lock();
				if (hasValue == false) {
					System.out.println("out 222-222");
					condition.await();
				}
				System.out.println("out 222");
				hasValue = false;
				condition.signalAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static class MyThreadA extends Thread {
		private MyService myService;

		public MyThreadA(MyService myService) {
			this.myService = myService;
		}

		public void run() {
			try {
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					myService.set();
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public static class MyThreadB extends Thread {
		private MyService myService;

		public MyThreadB(MyService myService) {
			this.myService = myService;
		}

		public void run() {
			try {
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					myService.get();
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
}
