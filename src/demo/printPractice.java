package demo;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class printPractice {
    static volatile int count = 0;
   public static void main(String[] args){
       ReentrantLock lock = new ReentrantLock();
       Thread ji  = new Thread(()->{
         while(count<100){
             while(count%2==0){}
             System.out.println(Thread.currentThread().getName()+" "+count);
             count++;
         }
       });
       Thread ou  = new Thread(()->{
         while (count<100){
             while(count%2==1){}
             System.out.println(Thread.currentThread().getName()+" "+count);
             count++;
         }
       });
       ji.start();
       ou.start();
   }
}
