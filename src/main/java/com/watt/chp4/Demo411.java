package com.watt.chp4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.watt.chp3.Demo332.TTools;

public class Demo411 {

	public static class MyService {
		private Lock lock = new ReentrantLock();

		public void testMothed() {
			lock.lock();
			for (int i = 0; i < 5; i++) {
				System.out.println("线程名称:" + Thread.currentThread().getName() + "_" + (i + 1));

			}
			lock.unlock();
		}
	}

	public static class MyThread1 extends Thread {
		private MyService myService;

		public MyThread1(MyService myService) {
			this.myService = myService;
		}

		public void run() {
			try {
				myService.testMothed();
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
