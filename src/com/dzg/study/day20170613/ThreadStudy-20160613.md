## 二、==synchronized同步语句块==
**==Git地址==**     
https://github.com/jsjjdzg/JavaThreadStudy/tree/master/src/com/dzg/study/day20170612B
https://github.com/jsjjdzg/JavaThreadStudy/tree/master/src/com/dzg/study/day20170613

> synchronized方法是对当前对象进行加锁，syschonized代码块是对某一个对象加锁

### 1.syschronized方法效率太低，可以将synchronized同步代码块放置在真正处理数据的地方提高执行效率
B线程必须等A线程使用完 同步方法才能执行该方法

### 2.使用synchronized同步代码块

该代码块，一段时间内只能被一个线程执行

```java
synchronized(this){
    ... ...
}
```
### 3.同一方法，不在synchronized代码块中异步执行，在块中同步执行

### 4.多个线程访问同一个object中的synchronized方法或者synchronized代码块时，该object中其他synchronized代码同时被阻塞(包括synchronized同步的方法)，调用是按顺序执行，同步阻塞

### 5.若是每次都是synchronized(this)对象，其他synchronized都被阻塞会大大降低效率，一般采用synchronized(非this)，不与其他锁this的方法争抢this锁，提高运行效率，其中非this锁每次相同会锁住，不同则不锁

### 6.为了防止脏读，需要对核心数据公共资源 synchronized(非this对象x) 来同步锁