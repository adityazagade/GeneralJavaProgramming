package design.creational.singleton;

public class LazyRegistryIODH {
    //Lazy Initialization using lazy initialization holder class. This ensures that, we have a lazy initialization
    // without worrying about synchronization;

    private LazyRegistryIODH() {
        System.out.println("LazyRegistryIODH constructor called");
    }

    private static class RegistryHolder {
        static LazyRegistryIODH INSTANCE = new LazyRegistryIODH();
    }

    public static LazyRegistryIODH getInstance() {
        return RegistryHolder.INSTANCE;
    }
}
