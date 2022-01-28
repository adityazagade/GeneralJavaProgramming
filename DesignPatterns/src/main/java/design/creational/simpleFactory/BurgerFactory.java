package design.creational.simpleFactory;

public class BurgerFactory {
    public static Burger getBurger(String type, String hotnessLevel) {
        BurgerType burgerType = BurgerType.valueOf(type);
        Scoville scoville = Scoville.valueOf(hotnessLevel);
        switch (burgerType) {
            case DOUBLE_DECKER:
                return new DoubleDecker(scoville);
            case MAHARAJA:
                return new Maharaja(scoville);
            default:
                throw new IllegalArgumentException("Burger type is unknown or does not exist");
        }
    }
}
