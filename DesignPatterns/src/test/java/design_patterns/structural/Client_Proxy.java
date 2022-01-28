package design_patterns.structural;

import design.structural.proxy.Image;
import design.structural.proxy.ImageFactory;
import design.structural.proxy.ImageFactoryy;
import design.structural.proxy.IvoryTower;
import design.structural.proxy.Tower;
import design.structural.proxy.TowerProxy;
import design.structural.proxy.Wizard;
import javafx.geometry.Point2D;

import java.lang.reflect.Proxy;

public class Client_Proxy {
    /*
     * What is the Proxy pattern?
     * Ans: Proxy Pattern provides a surrogate or placeholder for another object in order to access it.
     *
     * EXAMPLE:
     * Imagine a tower where the local wizard go to study their spells. The ivory tower can only be accessed through a
     * proxy which ensures that only the first three wizards can enter. Here the proxy represents the functionality and adds
     * access control to it.
     *
     * lazy loading of collection in hibernate
     * AOP based security provided by Spring framework;
     *
     * In plain words:
     * A class represents the functionality of another class.
     * */

    public static void main(String[] args) {
        // This is an example of protection proxy.
        Wizard v = new Wizard("VOLDEMORT");
        Wizard v1 = new Wizard("GANDALF");
        Wizard v2 = new Wizard("SAURON");
        Wizard v3 = new Wizard("ALBUS DUMBLEDORE");

        Tower iv = new IvoryTower();
        Tower iv1 = new TowerProxy(iv);
//        iv.enter(v);
//        iv.enter(v1);
//        iv.enter(v2);
//        iv.enter(v3);
        iv1.enter(v);
        iv1.enter(v1);
        iv1.enter(v2);
        iv1.enter(v3);

        //Example of Static proxy. (Also Virtual proxy)
        Image i = ImageFactory.getImage("icon.png");
        Point2D l1 = new Point2D(5, 5);
        i.setLocation(l1);
        System.out.println("Point2D =" + l1);

        Point2D l2 = i.getLocation();
        System.out.println("Point2D =" + l2);

        i.render();

        //Creating dynamic proxies using JAVA API.
        // what is java.lang.reflect.Proxy and wjava.lang.reflect.InvocationHandler
        String fileName = "joker.png";
        Image img = ImageFactoryy.getImage(fileName);
        img.setLocation(new Point2D(-5, -10));
        img.render();
    }

    /* Applicability:
     * Remote proxy provides a local representative for an object in a different address space.
     * Virtual proxy creates an expensive objects on demand.
     * Protection proxy controls access to the original object. Protection proxies are useful when objects should have
     * different access rights.
     *
     * Typical Use Case
     *  - Control access to another object
     *  - Lazy initialization
     *  - Implement logging
     *  - Facilitate network connection
     *  - Count references to an object
     *
     * Another type is the virtual proxy.
     * Virtual proxies are used when an object is expensive to instantiate.
     * In the implementation the proxy manages the lifetime of the real subject.
     * It decides when the instance creation is needed and when it can be reused.
     * Virtual proxies are used to optimize performance.
     *
     * Caching proxies are used to cache expensive calls to the real subject.
     * There are multiple caching strategies that the proxy can use.
     * Some examples are read-through, write-through, cache-aside and time-based.
     * The caching proxies are used for enhancing performance
     *
     * Remote proxies are used in distributed object communication.
     * Invoking a local object method on the remote proxy causes execution on the remote object.
     */
}
