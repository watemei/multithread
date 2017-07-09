package com.watt.chp;

import org.junit.Test;

import com.watt.chp3.Demo313;
import com.watt.chp3.Demo332;
import com.watt.chp3.Demo313.C;
import com.watt.chp3.Demo313.MyThread1;
import com.watt.chp3.Demo313.MyThread2;
import com.watt.chp3.Demo313.MyThreadC;
import com.watt.chp3.Demo313.MyThreadP;
import com.watt.chp3.Demo313.P;
import com.watt.chp3.Demo332.TTools;

public class Demo3Test {

	/**
	 * 没有对象监视器，也就没有同步加锁。
	 * 
	 * @param args
	 */
	@Test
	public void waitStrTest() {
		try {
			String newString = new String("");
			newString.wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void waitStr2Test() {
		try {
			String lock = new String("");
			System.out.println("syn 上面代码");
			synchronized (lock) {
				System.out.println("第一行");
				lock.wait();
				System.out.println("第二行");
			}
			System.out.println("syn 下面代码");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void waitNotifyTest() {
		try {
			Object lock = new String("");
			MyThread1 myThread1 = new Demo313.MyThread1(lock);
			myThread1.start();
			Thread.sleep(3000);
			MyThread2 myThread2 = new Demo313.MyThread2(lock);
			myThread2.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void PCTest() {
		try {
			Object lock = new String("");
			P p = new Demo313.P(lock);
			C c = new Demo313.C(lock);
			MyThreadP[] myThreadP = new Demo313.MyThreadP[2];
			MyThreadC[] myThreadC = new Demo313.MyThreadC[2];
			for (int i = 0; i < 2; i++) {
				myThreadP[i] = new Demo313.MyThreadP(p);
				myThreadP[i].setName("P" + (i + 1));
				myThreadC[i] = new Demo313.MyThreadC(c);
				myThreadC[i].setName("C" + (i + 1));
				myThreadP[i].start();
				myThreadC[i].start();
			}
			Thread.sleep(5000);
			Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
			Thread.currentThread().getThreadGroup().enumerate(threads);
			for (int i = 0; i < threads.length; i++) {
				System.out.println(threads[i].getName() + "-" + threads[i].getState());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void threadLocalTest() {

		Demo332.MyThread1 thread1 = new Demo332.MyThread1();
		Demo332.MyThread2 thread2 = new Demo332.MyThread2();
		thread1.start();
		thread2.start();
		for (int i = 0; i < 100; i++) {
			TTools.threadLocal.set("Mian" + (i + 1));
			System.out.println("Mian" + TTools.threadLocal.get());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
