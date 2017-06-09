# Java多线程基本内容(简单带过)
**==Git地址==** https://github.com/jsjjdzg/JavaThreadStudy

## 使用多线程
**==集成Thread类，重写run方法  
实现Runnable接口，实现run方法（建议使用）==**

---

## currentThread()

**Thread.currentThread() 返回 该代码正在被哪个线程调用的信息**  

```
如：Thread.currentThread().getName() 返回线程名称
```
---

## isAlive()
**判断当前线程是否处于活动状态** ==即为== **当前线程还在运行尚未终止**

---

## sleep()
**Thread.sleep(XXX) 让当前线程在XXX毫秒内休眠**

---
## getId()
**getId() 可获得线程的唯一标识**

---

## ==停止线程==

```
1.自然完成线程任务
2.stop()方法，不建议使用
3.interrupt()中断线程
```
**推荐使用抛异常来停止线程，这样可以捕捉异常来进行相关处理  
也可以使用 return 配合 interrupt来停止**

**线程类：**
```java
package com.dzg.study.day20170609;

/**
 * 
 * 停止线程
 * 推荐使用抛异常来停止线程，这样可以捕捉异常来进行相关处理
 * 也可以使用 return 配合 interrupt来停止
 * 
 * @author DZG
 * @since V1.0 2017年6月9日
 */
public class InterruptThreadDemo extends Thread {

	/**
	 * 可以使用 ： interrupt() 和 return 结合停止线程
	 */
	@Override
	public void run() {
		while(true){
			if(this.isInterrupted()){
				System.out.println("停止线程");
				return;
			}
			System.out.println(System.currentTimeMillis());
		}
	}
	
		
	/**
	 * 使用异常停止线程
	 */
	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 500000; i++) {
				if (this.isInterrupted()) {
					System.out.println("停止线程");
					throw new InterruptedException();// 线程停止抛出异常
				}
				System.out.println("i = " + i);
			}
			System.out.println("输出，for结束");
		} catch (InterruptedException e) {
			System.out.println("进入异常catch方法");
			e.printStackTrace();
		}
	}
	
	/**
	 * 在睡眠中sleep()中停止线程
	 */
	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i <= 20000; i++) {
				System.out.println("i = " + i);
			}
			System.out.println("begin");
			Thread.sleep(100000);
			System.out.println("end");
		} catch (InterruptedException e) {
			System.out.println("睡眠中被停止线程");
			e.printStackTrace();
		}
	}
	
	/**
	 * stop()暴力停止线程(不使用)
	 * 会导致流程破坏，比如流程为走完，被停止
	 * 
	 */
	@Override
	public void run() {
		int i = 0;
		super.run();
		try {
			while(true){
				i++;
				System.out.println("i = " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("睡眠中被停止线程");
			e.printStackTrace();
		}
	}
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		super.run();
		try {
			this.stop();// stop方法会隐式抛出ThreadDeath异常
		} catch (ThreadDeath e) {
			System.out.println("stop()方法抛出了ThreadDeath异常");
			e.printStackTrace();
		}
	}
}

```

**运行main类**

```java
package com.dzg.study.day20170609;

public class RunInterruptDemo {

	/**
	 * 建议使用 ： interrupt() 和 return 结合停止线程
	 */
	public static void main(String[] args) throws InterruptedException {
		InterruptThreadDemo thread = new InterruptThreadDemo();
		thread.start();
		Thread.sleep(500);
		thread.interrupt();
		System.out.println("main end");
	}
	
	/**
	 * 使用异常停止线程
	 */
	public static void main(String[] args) throws InterruptedException {
		InterruptThreadDemo thread = new InterruptThreadDemo();
		thread.start();
		Thread.sleep(100);
		thread.interrupt();
		System.out.println("main end");
	}
	
	/**
	 * 在睡眠中sleep()中停止线程
	 */
	public static void main(String[] args) throws InterruptedException {
		InterruptThreadDemo thread = new InterruptThreadDemo();
		thread.start();
		thread.interrupt();
		System.out.println("main end");
	}
	
	/**
	 * stop()暴力停止线程
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		InterruptThreadDemo thread = new InterruptThreadDemo();
		thread.start();
		Thread.sleep(10000);
		thread.stop();
		System.out.println("main end");
	}
	public static void main(String[] args) throws InterruptedException {
		InterruptThreadDemo thread = new InterruptThreadDemo();
		thread.start();
		System.out.println("main end");
	}
}

```

---

## 暂停线程

**Java多线程，使用suspend()暂停线程，使用resume()方法恢复线程。**

```
1.suspend()，resume()方法会独占资源。
一个方法被suspend，但没有resume会一直卡着无法继续。

2.suspend()，resume()方法 会产生不同步效果。
一个方法中对某些变量做数据更改，但是更新一半被暂停，但是另外一个线程来调用，会发生数据不同步。
```
---

## yield()

**放弃当前CPU资源**，放弃时间不确定，也可能刚放弃马上获取CPU时间片.

---

## 线程的优先级

**优先级较高的线程获得CPU时间更多，1-10划分等级**

```
1. 线程的优先级可以集成。
通过A线程启动B线程，那么B线程的优先级和A线程是一样的

2.优先级具有规则性
高优先级的线程大部分内容会先执行完（不是一定CPU时间都属于他）

2.优先级具有随机性
优先级较高的线程不一定每次都先执行完
```

---

## 守护线程
Java中有2种线程，一种是用户线程，一种是守护(Daomon)线程  
**当进程中不存在非守护线程，守护线程自动销毁，典型就是 垃圾回收线程（GC）**
