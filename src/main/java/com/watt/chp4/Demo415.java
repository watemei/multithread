package com.watt.chp4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.watt.chp3.Demo332.TTools;

public class Demo415 {

	public static class MyService {
		private Lock lock = new ReentrantLock();
		private Condition condition = lock.newCondition();

		public void awaitA() {
			try {
				lock.lock();
				System.out.println("begin await timeA:" + System.currentTimeMillis() + " ThreadName="
						+ Thread.currentThread().getName());
				condition.await();
				System.out.println("end await timeA:" + System.currentTimeMillis() + " ThreadName="
						+ Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

		public void awaitB() {
			try {
				lock.lock();
				System.out.println("begin await timeB:" + System.currentTimeMillis() + " ThreadName="
						+ Thread.currentThread().getName());
				condition.await();
				System.out.println("end await timeB:" + System.currentTimeMillis() + " ThreadName="
						+ Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

		public void signalAll() {
			try {
				lock.lock();
				System.out.println(" signal all time:" + System.currentTimeMillis());
				condition.signalAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
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
				myService.awaitA();
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
				myService.awaitB();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

}
