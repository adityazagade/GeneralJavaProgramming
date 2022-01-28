package design_patterns.creational;

import design.creational.simpleFactory.Burger;
import design.creational.simpleFactory.BurgerFactory;

public class Client_simpleFactory {
    public static void main(String[] args) {
        // taken input and stored it in variable type.
        String type = "MAHARAJA";
        String hotnessLevel = "MILD";
        Burger b = BurgerFactory.getBurger(type, hotnessLevel);
        System.out.println(b);

        type = "DOUBLE_DECKER";
        hotnessLevel = "HOT";
        //notice how we avoided unnecessary imports of Scoville which otherwise would have been here if we created the
        // Burger object here.
        Burger b2 = BurgerFactory.getBurger(type, hotnessLevel);
        System.out.println(b2);

        //We simply moved the instantiation logic away from the client code. Typically, with a static method.
        //Simple factory knows about all classes whose  objects it can create.
        // Simple factory is just encapsulation of our object creation logic. Hence not considered as a design pattern.
    }
}
