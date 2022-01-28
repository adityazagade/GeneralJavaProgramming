package beans.CollectionsDI;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

public class Test1 {
    private Vector fruits;
    private TreeSet cricketers;
    private Hashtable cc;

    public void setFruits(Vector fruits) {
        this.fruits = fruits;
    }

    public void setCricketers(TreeSet cricketers) {
        this.cricketers = cricketers;
    }

    public void setCc(Hashtable cc) {
        this.cc = cc;
    }

    public void printTestData() {
        System.out.println("Fruits ......");
        fruits.forEach(fruit -> {
            System.out.println(fruit);
            return;
        });

        System.out.println("cricketers ......");
        cricketers.forEach(player -> {
            System.out.println(player);
        });

        System.out.println("Country-capitals ........");
        Iterator iterator = cc.keySet().iterator();
        iterator.forEachRemaining(key -> {
            String capital = (String) cc.get(key);
            String country = (String) key;
            System.out.println("Country: " + country + " " + "Capital: " + capital);
        });
    }
}
