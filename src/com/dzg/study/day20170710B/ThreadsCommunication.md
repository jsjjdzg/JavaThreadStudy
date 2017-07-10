# 线程间通信

## 一、等待/通知机制(wait/notify)
**==Git地址==**  
https://github.com/jsjjdzg/JavaThreadStudy/tree/master/src/com/dzg/study/day20170705
https://github.com/jsjjdzg/JavaThreadStudy/tree/master/src/com/dzg/study/day20170706
https://github.com/jsjjdzg/JavaThreadStudy/tree/master/src/com/dzg/study/day20170707
https://github.com/jsjjdzg/JavaThreadStudy/tree/master/src/com/dzg/study/day20170710

**==wait使线程停止运行，notify使停止的线程继续运行==**  

### 1.等待/通知机制实现

1. **==wait()==** 
    1. 作用是使当前执行代码的线程就行等待，直到接收到通知/中断为止。 
    2. 调用wait()方法时必须获得对象级锁，也就是 ==**只能在同步方法/同步块调用**== wait()。
2. **==notify()==** 
    1. 作用通知该对象锁的等待线程，如有多个线程等待，由线程规划器随机挑选一个wait的线程。
    2. 也 ==**只能在同步方法/同步块调用**== notify()。
    3. 要等到执行notify()将程序执行完，即 ==**退出synchronized代码块后，才会释放锁**== ，wait的线程才会等到锁。

### 2.wait()释放锁/notify()锁不释放

**wait()会立即释放锁，notify()需要等到synchronized方法/代码块执行完释放锁**

### 3.wait(long x) 等待某一定时间是否有线程对锁进行唤醒，超出时间自动唤醒

### 4.==wait()等待需要放置在while条件内==，不要放在if条件内
确保notify通知后 wait需要再次检查条件是否满足/改变

### 5.生产者/消费者 模式原理基于 wait/notify

1. **wait() 使用while判断  ==防止条件改变==**
2. **通知使用notify ==防止假死==**

#### 一生产与一消费  
#### 多生产与多消费 多生产与一消费 一生产与多消费
会出现 **==假死==** (生产者notify生产者，消费者notift消费者，就会一直wait下去)，需要notifyAll()


```java
// 生产者
synchronized (lock) {
	while (!ValueObject.value.equals("")) {
		lock.wait();
	}
	String value = System.currentTimeMillis() + "";
	ValueObject.value = value;
	lock.notifyAll();
}

// 消费者
synchronized (lock) {
	while (ValueObject.value.equals("")) {
		lock.wait();
	}
	ValueObject.value = "";
	lock.notifyAll();
}
```
### 6.通过==管道流==进行线程间通信
**==管道流(pipeStream)==** 是一种特殊的流，用于不同线程之间直接传输数据
1. PipedInputStream/PipedOutputStream
2. PipedReader/PipedWriter


### 6.1 通过==管道流==进行线程间通信：字节流
**==PipedInputStream/PipedOutputStream==**

PipedInputStream 读取字节时为空会阻塞直到有数据写入才会向下运行

```java
// 读取数据
public void readData(PipedInputStream in) {
	try {
		System.out.println("开始读取");
		byte[] byteArray = new byte[2];
		// 若是没有数据会被一直阻塞，直到有数据为止
		int length = in.read(byteArray); 
		while (length != -1) {
			String newData = new String(byteArray, 0, length);
			System.out.print(newData);
			length = in.read(byteArray);
		}
		System.out.println();
		System.out.println("读取完毕");
		in.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

// 写入
public void write(PipedOutputStream out) {
	try {
		System.out.println("开始写入");
		for (int i = 0; i < 100; i++) {
			String b = i + "";
			out.write(b.getBytes());
			System.out.print(b);
		}
		System.out.println();
		System.out.println("写入完毕");
		out.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}


// 运行时 需要先连接
pos.connect(pis);
pis.connect(pos); 
```
### 6.2 通过==管道流==进行线程间通信：字符流
**==PipedWriter/PipedReader==**


```java
// 读取
public void read(PipedReader pr) {
	try {
		System.out.println("开始读取字符流");
		char[] charArray = new char[100];
		int length = pr.read(charArray);
		while (length != -1) {
			String str = new String(charArray, 0, length);
			System.out.print(str);
			length = pr.read(charArray);
		}
		System.out.println();
		System.out.println("结束读取字符流");
		pr.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

// 写入
public void write(PipedWriter pw) {
	try {
		System.out.println("开始写入字符流");
		for (int i = 0; i < 100; i++) {
			String a = i + "";
			pw.write(a);
			System.out.print(a);
		}
		System.out.println();
		System.out.println("结束写入字符流");
		pw.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

// 运行时需要链接
pr.connect(pw);
//pw.connect(pr);
```

---

## 二、join方法
**==Git地址==**  
https://github.com/jsjjdzg/JavaThreadStudy/tree/master/src/com/dzg/study/day20170710B

**==join()方法就是等待线程对象销毁==**

### 1. 使用join()
下例中a.join()方法是使线程对象a正常执行run方法而无限期阻塞main方法，直到a线程销毁。即先执行完执行join()的线程才会继续。
```java
public static void main(String[] args){
    try{
        ThreadA a = new ThreadA();
        a.start();
        a.join();
        sys...
    } catch (Exception e) {
		e.printStackTrace();
	}
}
```
### 2. join()遇到interrupt() 会出现 InterruptdExcetion异常
即b线程中 a.join() ，然后将b线程interrupt() 

### 3. join(long x) 设定等待时间
### 4. join(long x) 和 sleep(long x) 的区别

**==join(long)通过wait(long) 来实现，所以join(long)会释放锁==**     
sleep(long) 不会释放锁

> 线程B有个同步方法等待调用

```java
/**
 * 
 * 线程B 有同步方法等待调用
 * 
 */
public class ThreadB extends Thread {

    public void run() {
    	try {
        	System.out.println("线程B run 方法 begin");
        	Thread.sleep(5000);
        	System.out.println("线程B run 方法 end");
    	} catch (Exception e) {
	        e.printStackTrace();
    	}
    }
    
    synchronized public void execute() {
	    System.out.println("线程B execute 方法被调用");
    }
}
```
> 线程A 已b线程为锁对象 启动B线程


```java
/**
 * 
 * join(long) 会释放锁(底层有wait()实现)
 * sleep(long) 不会释放素
 * 
 */
public class ThreadA extends Thread {

    private ThreadB b;
    
    public ThreadA(ThreadB b) {
    	super();
    	this.b = b;
    }
    
    public void run() {
    	try {
        	synchronized (b) {
        		b.start();
        		b.join(5000);
        		//Thread.sleep(6000);
        	}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
```
> 线程C调用线程B的同步方法

线程A中b.join(long x)，使B线程b对象run方法执行完再继续，会释放b对象同步锁，C线程可以调用B线程的同步方法。    

线程A中b.sleep(long x)，使B线程b对象run方法执行完再继续，不会释放b对象同步锁，C线程需要等b对象run方法执行完，才可以调用B线程的同步方法。    

### 5. join(long)是抢到锁然后立即释放锁，如果join(long)抢到锁发现时间已过，释放锁.