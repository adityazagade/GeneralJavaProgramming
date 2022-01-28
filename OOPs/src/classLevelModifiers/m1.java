package classLevelModifiers;

public class m1 {
    m2 m = new m2();
    /*
    * When ever we create a class, we need to tell few things about it to the JVM. We do that using modifiers.
    * 1. Is the class accessible to outside world? (public)
    * 2. Can this class be instantiated? (abstract)
    * 3. Can this class have sub-classes? (final)
    * */

    // what about inner class ? Apart from the already mentioned modifiers, you have few more available.
    private class m1Inner {}
    static class m1Inner1 {}
    protected class m1Inner2 {}

    // m1Inner a1 = new m1Inner();
    // m1Inner2 a2 = new m1Inner2();
}

abstract class m1a {} //abstract
class m1b {} //default
final class m1c {} //final