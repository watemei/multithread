package com.watt.chp;

import org.junit.Test;

import com.watt.chp4.Demo413;
import com.watt.chp4.Demo415;
import com.watt.chp4.Demo416;
import com.watt.chp4.Demo417;
import com.watt.chp4.Demo418;

public class Demo4Test {

	@Test
	public void waitTest() {
		Demo413.MyService service = new Demo413.MyService();
		Demo413.MyThread1 myThread1 = new Demo413.MyThread1(service);
		myThread1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.signal();
	}

	@Test
	public void waitSignalAllTest() {
		Demo415.MyService service = new Demo415.MyService();
		Demo415.MyThreadA myThreadA = new Demo415.MyThreadA(service);
		Demo415.MyThreadB myThreadB = new Demo415.MyThreadB(service);
		myThreadA.setName("A");
		myThreadA.start();
		myThreadB.setName("B");
		myThreadB.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.signalAll();
	}

	@Test
	public void waitSignalAll416Test() {
		Demo416.MyService service = new Demo416.MyService();
		Demo416.MyThreadA myThreadA = new Demo416.MyThreadA(service);
		Demo416.MyThreadB myThreadB = new Demo416.MyThreadB(service);
		myThreadA.setName("A");
		myThreadA.start();
		myThreadB.setName("B");
		myThreadB.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.signalAll_A();
	}

	@Test
	public void waitSignalAll417Test() {
		Demo417.MyService service = new Demo417.MyService();
		Demo417.MyThreadA myThreadA = new Demo417.MyThreadA(service);
		Demo417.MyThreadB myThreadB = new Demo417.MyThreadB(service);
		myThreadA.setName("A");
		myThreadA.start();
		myThreadB.setName("B");
		myThreadB.start();
	}

	@Test
	public void waitSignalAll4171Test() {
		Demo417.MyService service = new Demo417.MyService();
		Demo417.MyThreadA[] myThreadAArr = new Demo417.MyThreadA[10];
		Demo417.MyThreadB[] myThreadBArr = new Demo417.MyThreadB[10];
		for (int i = 0; i < 10; i++) {
			myThreadAArr[i] = new Demo417.MyThreadA(service);
			myThreadBArr[i] = new Demo417.MyThreadB(service);
			Demo417.MyThreadA myThreadA = myThreadAArr[i];
			Demo417.MyThreadB myThreadB = myThreadBArr[i];
			myThreadA.setName("A");
			myThreadA.start();
			myThreadB.setName("B");
			myThreadB.start();
		}

	}
	
	@Test
	public void waitSignalAll418Test() {
		Demo418.MyService service = new Demo418.MyService();
		Demo418.MyThreadA[] myThreadAArr = new Demo418.MyThreadA[10];
		Demo418.MyThreadB[] myThreadBArr = new Demo418.MyThreadB[10];
		for (int i = 0; i < 10; i++) {
			myThreadAArr[i] = new Demo418.MyThreadA(service);
			myThreadBArr[i] = new Demo418.MyThreadB(service);
			Demo418.MyThreadA myThreadA = myThreadAArr[i];
			Demo418.MyThreadB myThreadB = myThreadBArr[i];
			myThreadA.setName("A");
			myThreadA.start();
			myThreadB.setName("B");
			myThreadB.start();
		}

	}

}
