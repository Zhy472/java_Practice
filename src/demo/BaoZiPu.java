package demo;

public class BaoZiPu extends Thread {
    private baozi bz;
    int times = 0;
    BaoZiPu(baozi bz){
        this.bz = bz;
    }

    public BaoZiPu() {

    }

    @Override
    public void run(){
        while(times<10){
            times++;
            synchronized(bz){
                if (bz.judge==true){
                    try{
                        bz.wait();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            System.out.println("做包子");
            bz.judge=true;
            bz.notify();
            }
        }
    }
}
