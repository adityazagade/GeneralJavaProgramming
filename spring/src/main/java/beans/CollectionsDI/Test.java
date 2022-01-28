package beans.CollectionsDI;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
    private List fruits;
    private Set cricketers;
    private Map cc;

    public void setFruits(List fruits) {
        this.fruits = fruits;
    }

    public void setCricketers(Set cricketers) {
        this.cricketers = cricketers;
    }

    public void setCc(Map cc) {
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
