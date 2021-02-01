package be.pxl.ja.oefening4;

import java.util.ArrayDeque;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductionLine {
    ArrayDeque<Package> l =  new ArrayDeque<>();

    public synchronized void addPackage(Package p){
        l.addLast(p);
    }

    public synchronized Package getPackage(){
        Package p = null;
        try {
            p = l.getFirst();
            l.removeFirst();
        }catch ( NoSuchElementException | NullPointerException e){
            e.printStackTrace();
        }
        return p;
    }
}
