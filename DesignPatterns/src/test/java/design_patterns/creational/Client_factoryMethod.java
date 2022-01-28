package design_patterns.creational;

import design.creational.factoryMethod.JSONMessageCreator;
import design.creational.factoryMethod.Message;
import design.creational.factoryMethod.MessageCreator;
import design.creational.factoryMethod.TextMessageCreator;

public class Client_factoryMethod {
    public static void main(String[] args) {
        //We want to move object creation logic to some other class.
        // We use this pattern when we do not know in advance which class we may need to instantiate
        // beforehand & also to allow new classes to be added to system and handle their creation without affecting the client code.

        // We let subclasses to decide which object to instantiate by overriding the factory method.

        // First create a class of our creator. The creator can itself be concrete if it can provide a default object
        // or it can be abstract

        //Implementation will override the method and return an object.
        MessageCreator mc = new JSONMessageCreator();
        Message m = mc.getMessage();
        System.out.println(m);
        mc = new TextMessageCreator();
        m = mc.getMessage();
        System.out.println(m);

        // The factory need not be a abstract class; You can keep it like a normal class and return default object.
        // Just like simple factory, we can accept additional arguments to choose between different object types.
        // Subclasses can then override the factory method to selectively create different objects for some criteria;


        //Design considerations
        // Creator hierarchy in factory method pattern reflects the product hierarchy. We typically end up with a concrete
        // creator per object type.

        //static method returning object instances are technically not GoF factory methods.

        // factory method allows us to create new objects without changing the client code. Just add the class and its factory. Done.

    }
}
