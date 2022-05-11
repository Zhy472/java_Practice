package demo;

public class ChiHuo extends Thread {
    private baozi bz;
    int time =0;
    ChiHuo(baozi bz){
        this.bz = bz;
    }
    @Override
    public void run(){
       while(time<=10){
           time++;
           synchronized(bz){
               if (bz.judge==false){
                   try{
                       bz.wait();
                   }
                   catch(Exception e){
                       e.printStackTrace();
                   }
               }
               System.out.println("吃包子");
               bz.judge=false;
               bz.notify();
           }
       }
    }
}
