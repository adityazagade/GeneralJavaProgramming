//package design_patterns.creational;
//
//import design.creational.ObjectPool.ObjectPool;
//import design.creational.ObjectPool.UserContext;
//
//public class Client_ObjectPool {
//
//    static ObjectPool pool = new ObjectPool<UserContext>(() -> {
//        return new UserContext();
//    }, 5);
//
//    public static void main(String[] args) {
//        /*What is Object Pool?
//         *
//         * Answer: In our system, if cost of creating an instance of a class is high and
//         * we need a large number of objects of this class for a short duration, then we can create an object pool.
//         *
//         * Here we can pre-create objects of the class or collect unused instances in an in memory cache.
//         * When code needs an object of this class, we provide it from this cache.
//         *
//         * It is one of the most complicated patterns to implement efficiently( and without defects)
//         * */
//
//        /*Implement Object Pool
//         * A thread safe caching of objects should be done in pool.
//         * Methods to acquire and release objects should be provided and pool should reset cached objects before
//         * giving them out.
//         *
//         * The reusuable object must provide methods to reset its state upon "release" by code.
//         *
//         * We have to decide whether to create new pooled objects when pool is empty or to wait until an object becomes available.
//         * Choice is influenced b1y whether the object is tied to a fixed number of external resources.
//         *
//         * */
////            UserContext uc = pool.getObject();
//    }
//}
