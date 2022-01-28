package design_patterns.creational;

import design.creational.abstractFactory.example1.AwsResourceFactory;
import design.creational.abstractFactory.example1.Capacity;
import design.creational.abstractFactory.example1.GoogleResourceFactory;
import design.creational.abstractFactory.example1.Instance;
import design.creational.abstractFactory.example1.ResourceFactory;
import design.creational.abstractFactory.example1.Storage;
import design.creational.abstractFactory.example2.App;
import design.creational.abstractFactory.example2.Example;

public class Client_AbstractFactory {
    private ResourceFactory factory;

    public Client_AbstractFactory(ResourceFactory resourceFactory) {
        this.factory = resourceFactory;
    }

    public static void main(String[] args) {
        // What is an Abstract Factory ?
        // Abstract factory is used when we have two or more objects which works together forming a kit or set and there can be
        // multiple sets of kits that can be created by client code.

        // So we seperate client code from concrete objects forming such a set and also from the code which creates these sets.

        // Implementation of Abstract Factory
        // 1. Create Abstract Factory as an abstract class of an interface.
        // 2. Abstract factory defines abstract methods for creating products.
        // 3. Provide concrete implementation of factory for each set of products.

        // Implementation Considerations
        // 1. Factories can be implemented as singletons, we typically ever need only one instance of it anyway.
        //    But make sure to familiarize yourself with drawbacks of singletons.
        // 2. Whenever you want to add a new product type, it required changes to the base factory as well as all
        //    implementations of factory.
        // 3. We provide the client code with conrete factory so that it can create objects.

        // Design Considerations.
        // 1. When we want to constrain object creations so that they all can work together then abstract factory is a good
        //    design pattern.
        // 2. Abstract factory uses factory method pattern.
        // 3. If the objects are too expensive to create then you can transperently switch factory implementation to use
        //    prototype design pattern to create objects.


        //I am starting to code it here.
        //First there has to be some way in which you decide which factory to you
        // Let us use a String to decide that /
        String type = "GOOGLE";
        ResourceFactory factory = null;
        Client_AbstractFactory c = null;
        Capacity cap = Capacity.micro;
        int size = 2050;
        if (type.equals("GOOGLE")) {
            c = new Client_AbstractFactory(new GoogleResourceFactory());
        } else if (type.equals("AWS")) {
            c = new Client_AbstractFactory(new AwsResourceFactory());
        }
        c.initialize(cap, size);

        // EXAMPLE 2
        System.out.println("================== Example 2 ==============");

        App app = new App();
        app.createKingdom((Example.FactoryMaker.makeFactory(Example.FactoryMaker.KingdomType.RAJPUT)));
        System.out.println(app.getKing() + " " + app.getCastle() + " " + app.getArmy());
    }

    private void initialize(Capacity c, int size) {
        Instance instance = factory.createInstance(c);
        Storage storage = factory.createStorage(size);
        instance.attachStorage(storage);
    }
}
