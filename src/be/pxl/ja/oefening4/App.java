package be.pxl.ja.oefening4;

public class App {
    public static void main(String[] args) {
        ProductionLine p = new ProductionLine();
        Producer p1 = new Producer(20, p);
        Producer p2 = new Producer(15, p);
        Producer p3 = new Producer(12, p);
        Producer p4 = new Producer(7, p);
        Consumer c = new Consumer(30, p);


        p1.start();
        p2.start();
        p3.start();
        p4.start();
        c.start();
    }

}
