package design_patterns.creational;

import design.creational.builder.example1.Armour;
import design.creational.builder.example1.HairColor;
import design.creational.builder.example1.HairType;
import design.creational.builder.example1.Hero;
import design.creational.builder.example1.Profession;
import design.creational.builder.example1.Weapon;

public class Client_builder {
    public static void main(String[] args) {
        // A hero can be of different type. We would pass all the dependencies required to create Hero from here (client).
        // We can create different representations of a hero by passing different arguments.
        // It will be to remember position of argument in the constructor, and you don't want to use telescoping constructor anti-pattern
        // In such a case, we should use Builder Pattern.
        Hero hero = new Hero.Builder("Bhishma", Profession.WARRIOR)
                .withArmor(Armour.CLOTHES)
                .withHairColor(HairColor.WHITE)
                .withHairType(HairType.CURLY)
                .withWeapon(Weapon.BOW)
                .build();
        System.out.println(hero.toString());
    }
}
