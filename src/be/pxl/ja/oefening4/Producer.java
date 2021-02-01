package be.pxl.ja.oefening4;

import java.util.Timer;

public class Producer extends Thread{

    private Timer timer = new Timer("Timer");
    int rate;
    ProductionLine productionLine;

    public Producer(int rate, ProductionLine productionLine){
        this.rate =rate;
        this.productionLine = productionLine;
        //timer.scheduleAtFixedRate(repeatedTask , 0, period);
    }

    @Override
    public void run(){
        for (int i = 0; i < rate; i++){
            Package p = new Package();
            productionLine.addPackage(p);
            System.out.println("package added " + p.toString());
            try {
                Thread.sleep((60 / rate) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
