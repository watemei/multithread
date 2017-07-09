package com.watt.chp2;

public class Demo221 {

	/**
	 * 用关键字synchronized方法在某种情况下是有弊端的，在执行长时间任务时存在等待，这种情况下可以使用同步代码块提高执行效率。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Task task = new Task();
		MyThread1 myThread1 = new MyThread1(task);
		MyThread2 myThread2 = new MyThread2(task);
		myThread1.start();
		myThread2.start();

		MyThread3 myThread3 = new MyThread3(task);
		MyThread4 myThread4 = new MyThread4(task);
		myThread3.start();
		myThread4.start();

	}

	public static class Task {
		private String getData1;
		private String getData2;

		public synchronized void doLongTimeTask() {
			try {
				System.out.println("begin task");
				Thread.sleep(3000);
				getData1 = "长时间处理任务后从远程返回的值 1 threadName=" + Thread.currentThread().getName();
				getData2 = "长时间处理任务后从远程返回的值 2 threadName=" + Thread.currentThread().getName();
				System.out.println(getData1);
				System.out.println(getData2);
				System.out.println("end task");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void doLongTimeTaskSynCode() {
			try {
				System.out.println("begin task");
				Thread.sleep(3000);
				String privateGetData1 = "长时间处理任务后从远程返回的值 3 threadName=" + Thread.currentThread().getName();
				String privateGetData2 = "长时间处理任务后从远程返回的值 4 threadName=" + Thread.currentThread().getName();
				synchronized (this) {
					getData1 = privateGetData1;
					getData2 = privateGetData2;
				}
				System.out.println(getData1);
				System.out.println(getData2);
				System.out.println("end task");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static class MyThread1 extends Thread {
		private Task task;

		public MyThread1(Task task) {
			super();
			this.task = task;
		}

		public void run() {
			super.run();
			task.doLongTimeTask();
		}
	}

	public static class MyThread2 extends Thread {
		private Task task;

		public MyThread2(Task task) {
			super();
			this.task = task;
		}

		public void run() {
			super.run();
			task.doLongTimeTask();
		}
	}

	public static class MyThread3 extends Thread {
		private Task task;

		public MyThread3(Task task) {
			super();
			this.task = task;
		}

		public void run() {
			super.run();
			task.doLongTimeTaskSynCode();
		}
	}

	public static class MyThread4 extends Thread {
		private Task task;

		public MyThread4(Task task) {
			super();
			this.task = task;
		}

		public void run() {
			super.run();
			task.doLongTimeTaskSynCode();
		}
	}

}
