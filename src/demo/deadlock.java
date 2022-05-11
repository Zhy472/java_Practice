package demo;

import java.util.concurrent.locks.ReentrantLock;

public class deadlock  {
    private static Object object1 = new Object();
    private static Object object2 = new Object();
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args){
        new Thread(()->{
            synchronized(object1){
                System.out.println(1);
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                synchronized(object2){
                    System.out.println(2);
                }

            }

        }).start();
        new Thread(()->{
            synchronized(object2){
                System.out.println(2);
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                synchronized(object1){
                    System.out.println(1);
                }
            }
        }).start();
    }

}
