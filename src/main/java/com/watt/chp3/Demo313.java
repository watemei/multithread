package com.watt.chp3;

public class Demo313 {

	public static class MyThread1 extends Thread {
		private Object lock;

		public MyThread1(Object lock) {
			super();
			this.lock = lock;
		}

		public void run() {
			try {

				synchronized (lock) {
					System.out.println("开始 wait time＝" + System.currentTimeMillis());
					lock.wait();
					System.out.println("结束 wait time＝" + System.currentTimeMillis());
				}
			} catch (Exception exception) {

			}
		}
	}

	public static class MyThread2 extends Thread {
		private Object lock;

		public MyThread2(Object lock) {
			super();
			this.lock = lock;
		}

		public void run() {
			try {

				synchronized (lock) {
					System.out.println("开始 notify time＝" + System.currentTimeMillis());
					lock.notify();
					System.out.println("结束 notify time＝" + System.currentTimeMillis());
				}
			} catch (Exception exception) {

			}
		}
	}

	public static class C {
		private Object lock;

		public C(Object lock) {
			super();
			this.lock = lock;
		}

		public void getValue() {
			try {
				synchronized (lock) {
					if (ValueObject.value.equals("")) {
						System.out.println("消费者：" + Thread.currentThread().getName() + "waiting 1");
						lock.wait();
					}
					System.out.println("消费者＝" + Thread.currentThread().getName() + "Running 2");
					ValueObject.value = "";
					lock.notify();
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public static class P {
		private Object lock;

		public P(Object lock) {
			super();
			this.lock = lock;
		}

		public void setValue() {
			try {
				synchronized (lock) {
					if (ValueObject.value.equals("")) {
						System.out.println("生产者：" + Thread.currentThread().getName() + "waiting 1");
						lock.wait();
					}
					System.out.println("生产者＝" + Thread.currentThread().getName() + "Running 2");
					ValueObject.value = System.currentTimeMillis() + "_" + System.nanoTime();
					lock.notify();
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public static class MyThreadP extends Thread {
		private P p;

		public MyThreadP(P p) {
			super();
			this.p = p;
		}

		public void run() {
			p.setValue();
		}
	}

	public static class MyThreadC extends Thread {
		private C c;

		public MyThreadC(C c) {
			super();
			this.c = c;
		}

		public void run() {
			while (true) {
				c.getValue();
			}
		}
	}

	public static class ValueObject {
		public static String value = "";

	}

}
