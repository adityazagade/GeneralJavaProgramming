package design.creational.singleton;

public class LazyRegistry {
    private LazyRegistry() {
    }

    private static volatile LazyRegistry INSTANCE = null;

    public static LazyRegistry getInstance() {
        // This is not thread safe.
//        if (INSTANCE == null) {
//            INSTANCE = new LazyRegistry();
//        }
//        return INSTANCE;

        // double check locking and use of volatile.
        // Using volatile we tell java to not use the cached values of the variable.
        if (INSTANCE == null) {
            synchronized (LazyRegistry.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyRegistry();
                }
            }
        }
        return INSTANCE;
    }
}
