package com.watt.chp2;

public class Demo227 {

	/**
	 * 将任意对象作为监听器对象。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Service service = new Service();
		for (int i = 0; i < 5; i++) {
			MyThread1 myThread1 = new MyThread1(service);
			myThread1.setName("A" + i);
			myThread1.start();
			MyThread2 myThread2 = new MyThread2(service);
			myThread2.setName("B" + i);
			myThread2.start();

			MyThread3 myThread3 = new MyThread3(service);
			myThread3.setName("C" + i);
			myThread3.start();
			MyThread4 myThread4 = new MyThread4(service);
			myThread4.setName("D" + i);
			myThread4.start();
		}
	}

	public static class Service {
		private String userName;
		private String password;

		private String anyString = new String();

		public void setUserNamePassWord(String userName, String password) {
			try {
				synchronized (this) {
					System.out.println(
							"线程名称:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入同步块！");
					userName = userName;
					Thread.sleep(3000);
					password = password;
					System.out.println(
							"线程名称:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开同步块！");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void setUserNamePassWord2(String userName, String password) {
			try {
				synchronized (this) {
					System.out.println(
							"线程名称:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入同步块！");
					userName = userName;
					Thread.sleep(3000);
					password = password;
					System.out.println(
							"线程名称:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开同步块！");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static class MyThread1 extends Thread {
		private Service service;

		public MyThread1(Service Service) {
			super();
			this.service = Service;
		}

		public void run() {
			super.run();
			service.setUserNamePassWord("a", "aa");
		}
	}

	public static class MyThread2 extends Thread {
		private Service service;

		public MyThread2(Service Service) {
			super();
			this.service = Service;
		}

		public void run() {
			super.run();
			service.setUserNamePassWord("b", "bb");
		}
	}

	public static class MyThread3 extends Thread {
		private Service service;

		public MyThread3(Service Service) {
			super();
			this.service = Service;
		}

		public void run() {
			super.run();
			service.setUserNamePassWord("c", "cc");
		}
	}

	public static class MyThread4 extends Thread {
		private Service service;

		public MyThread4(Service Service) {
			super();
			this.service = Service;
		}

		public void run() {
			super.run();
			service.setUserNamePassWord2("d", "dd");
		}
	}
}
