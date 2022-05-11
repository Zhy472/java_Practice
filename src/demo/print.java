package demo;

import java.util.concurrent.locks.ReentrantLock;

public class print {
    static ReentrantLock reentRantLock = new ReentrantLock();
    static volatile int count = 0;
    public static void main(String[] args){
        Thread thread1 = new Thread(()->{
            while(count<100){
                reentRantLock.lock();
                if ((count&1)==1){
                    System.out.println(Thread.currentThread().getName()+":"+count);
                    count++;
                }
                reentRantLock.unlock();
            }
        });
        Thread thread2 = new Thread(()->{
            while(count<100){
                reentRantLock.lock();
                if ((count&1)==0) {
                    System.out.println(Thread.currentThread().getName()+":"+count);
                    count++;
                }
                reentRantLock.unlock();
            }
        });
        thread1.start();
        thread2.start();
    }
}
