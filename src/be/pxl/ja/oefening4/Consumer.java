package be.pxl.ja.oefening4;

import java.util.Timer;

public class Consumer extends Thread{

    private Timer timer = new Timer("Timer");
    int rate;
    ProductionLine productionLine;

    public Consumer(int rate, ProductionLine productionLine){
        this.rate =rate;
        this.productionLine = productionLine;

    }

    @Override
    public void run(){
        for (int i = 0; i < rate; i++){
            Package p =  productionLine.getPackage();
            System.out.println("package removed " + p.toString());

            try {
                Thread.sleep((60 / rate) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
