package com.watt.chp3;

public class Demo332 {

	public static class TTools {
		public static ThreadLocal threadLocal = new ThreadLocal();
	}

	public static class MyThread1 extends Thread {
		public MyThread1() {
		}

		public void run() {
			try {
				for (int i = 0; i < 100; i++) {
					TTools.threadLocal.set("ThreadA" + (i + 1));
					System.out.println("ThreadA" + TTools.threadLocal.get());
					Thread.sleep(200);
				}
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
