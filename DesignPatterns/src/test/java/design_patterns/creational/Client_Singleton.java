package design_patterns.creational;

import design.creational.singleton.EagerRegistry;
import design.creational.singleton.LazyRegistry;
import design.creational.singleton.LazyRegistryIODH;

public class Client_Singleton {
    public static void main(String[] args) throws ClassNotFoundException {
        EagerRegistry registry = EagerRegistry.getInstance();
        System.out.println(registry);

        LazyRegistry l1 = LazyRegistry.getInstance();
        LazyRegistry l2 = LazyRegistry.getInstance();
        LazyRegistry l3 = LazyRegistry.getInstance();
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);


        Class.forName("design.creational.singleton.LazyRegistryIODH");
        System.out.println("Anythin happened?");
        LazyRegistryIODH l = LazyRegistryIODH.getInstance();
        System.out.println("how about now?");


        /*Implementation Considerations
        * 1. Eager/Early initialization is the simplest and preferred way. Always try to use this
        * approach first
        * 2.The classic singleton pattern implementation uses double check locking and volatile field
        * 3. The lazy initialization holder idiom provides the best of both worlds. you won't need to
        * deal with synchronization issues directly and is easy to implement.
        * 4. You can also declare singleton using enums. However, due to pre-conceptions about what an
        * enum is, it may be a hard sell during code review especially if singleton has mutable fields.
        * */

        /*Design considerations
        * 1. Single creation does not need any parameters. If you find yourself in a situation where you
        * need constructor arguements, you need a simple factory or factory method pattern instead.
        *
        * 2. Make sure that your singleton are not carrying a lof of mutable global state.
        * */


        /*Why is singleton an anti pattern*/

        /*Pitfalls
        * 1. Singleton pattern can deceive you about the true dependencies! Since they are globally accessible its easy to miss dependencies
        * 2. Hard to unit tests.You cannot easily mock the instance that is returned.
        * 3. Most common way to implement Singletons in Java is through static variables and they are held per
        * class loader and per JVM. So they many not be truely Singleton in an OSGi or web application.
        * 4. A singleton carrying around a large mutuable global state is a good indication of an abused Singleton pattern.
        *
        * */
    }
}
