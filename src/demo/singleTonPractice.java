package demo;

public class singleTonPractice {
    static volatile singleTonPractice singleTonPractice;
    private singleTonPractice(){};
    public static singleTonPractice getSingleTonPractice(){
        if(singleTonPractice==null){
            synchronized(singleTonPractice.class){
                if(singleTonPractice==null){
                    singleTonPractice = new singleTonPractice();
                }
            }
        }
        return singleTonPractice;
    }
}
