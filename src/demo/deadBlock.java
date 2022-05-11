package demo;

import java.util.Deque;

public class deadBlock {
    public static Object object1 = new Object();
    public static Object object2 = new Object();
    public static void main(String[] args){
        new Thread(
                ()->{
                    try{
                        synchronized (object1){
                            Thread.sleep(3000);

                        }
                        synchronized(object2){
                            System.out.println(1);
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                }
        ).start();
        new Thread(
                ()->{
                    try{
                        synchronized (object2){
                            Thread.sleep(3000);
                            synchronized(object1){
                                System.out.println(2);
                            }
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                }
        ).start();

    }
}
