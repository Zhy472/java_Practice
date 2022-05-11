package demo;

public class deadLock2 {
    private static Object a = new Object();
    private static Object b = new Object();
    private static volatile int count = 0;
    public static void main(String[] args) {
        Thread one = new Thread(()->{
            while(count<10){
                synchronized(a){
                    System.out.println(Thread.currentThread().getName()+" "+10);
                    try{Thread.sleep(1000);}
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    synchronized(b){
                        System.out.println(Thread.currentThread().getName()+" "+20);
                    }
                }
                count++;
            }
        });
        Thread two = new Thread(()->{
            while(count<10){
                synchronized(b){
                    System.out.println(Thread.currentThread().getName()+" "+30);
                    try{Thread.sleep(1000);}
                    catch(Exception e){
                        e.printStackTrace();
                    }

                }
                synchronized(a){
                    System.out.println(Thread.currentThread().getName()+" "+30);
                }
                count++;
            }
        });
        one.start();
        two.start();
    }
}
