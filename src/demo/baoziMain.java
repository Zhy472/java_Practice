package demo;

public class baoziMain {
    public static void main(String[] args) {
        baozi bz = new baozi();
        BaoZiPu baoZiPu = new BaoZiPu(bz);
        ChiHuo chiHuo = new ChiHuo(bz);
        baoZiPu.start();
        chiHuo.start();
    }
}
