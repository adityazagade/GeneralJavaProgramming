package design_patterns.creational;

import design.creational.prototype.Sheep;

public class Client_prototype {
    public static void main(String[] args) {
        // we have a complex object that is costly to create. To create more instances of such class, we use an existing
        // instances as our prototype.

        //Prototype will allow us to make copies of existing object and save us from having to recreate objects from scratch.

        // Create a class and that class must implement a Cloneable interface.
        // Class should override clone method and return copy of itself.
        // The method should declare CloneNotSupportedException in throws clause to give subclasses change to decide on whether
        // to support cloning.

        //Clone method should consider the deep and shallow copy and choose which-ever is applicable.

        //Implementation Considerations ..
        // 1. Pay attention to the deep copy, and the shallow copy of references. Immutable fields on clones save the trouble of deep copy.
        // 2. Make sure to reset the mutable state of the object before returning the prototype. It's a good idea to implement
        // this in the method to allow subclasses to initialize themselves.

        //Prototypes are useful when you have large objects where majority of state is unchanged between instances
        // and you can easily identify that state.

        //A prototype registry is a class where in you can register various prototypes which other code can access to clone out instances.
        // This solves the issue of getting access to initial instance

        // Prototypes are useful when we are working with Composite and Decorator patterns.
        Sheep sheep = new Sheep();
        sheep.setName("Dolly");
        System.out.println("sheep " + sheep.getName());

        Sheep sheep2 = null;
        try {
            sheep2 = (Sheep) sheep.clone();
            System.out.println("sheep2 " + sheep2.getName());
            System.out.println("sheep " + sheep.getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        sheep2.setName("Molly");
        System.out.println("sheep2 " + sheep2.getName());
        System.out.println("sheep " + sheep.getName());
    }
}
