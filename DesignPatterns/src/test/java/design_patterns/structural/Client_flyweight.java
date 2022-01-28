package design_patterns.structural;

import design.structural.flyweight.PotionFactory;
import design.structural.flyweight.PotionType;

public class Client_flyweight {
    /*
     * Intent:
     * Use sharing to support large numbers of fine-grained objects efficiently.
     *
     * Explanation:
     * An alchemist's shop has selves full of magic potions. Many of the potions are same so there is no need to create
     * new object for each of them. Instead one object instance can  represent multiple shelf items so memory footprint remains small.
     *
     * It is used to minimize memory usage or computational expenses by sharing as much as possible with similar objects.
     * */

    public static void main(String[] args) {
        PotionFactory factory = new PotionFactory();
        factory.createPotion(PotionType.INVISIBILITY).drink(); // You become invisible. (Potion=6566818)
        factory.createPotion(PotionType.HEALING).drink(); // You feel healed. (Potion=648129364)
        factory.createPotion(PotionType.INVISIBILITY).drink(); // You become invisible. (Potion=6566818)
        factory.createPotion(PotionType.HOLY_WATER).drink(); // You feel blessed. (Potion=1104106489)
        factory.createPotion(PotionType.HOLY_WATER).drink(); // You feel blessed. (Potion=1104106489)
        factory.createPotion(PotionType.HEALING).drink(); // You feel healed. (Potion=648129364)

        /*
        * java.lang.Integer#valueOf(int) and similarly for Byte, Character and other wrapped types.
        */
    }
}
