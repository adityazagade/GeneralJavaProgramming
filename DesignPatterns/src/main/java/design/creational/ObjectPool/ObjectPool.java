package design.creational.ObjectPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Supplier;

public class ObjectPool<T extends IPoolable> {

    public ObjectPool(Supplier<T> creator, int size) {
        pool = new LinkedBlockingDeque<>();
        for (int i = 0; i < size; i++) {
            pool.add(creator.get());
        }
    }

    private BlockingQueue<T> pool;

    public T getObject() {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            System.out.println("Looks like we don't have anything in pool");
        }
        // either we decide to provide an object by creating it or decide to wait..
        return null;
    }

    public void releaseObject(T object) {
        object.reset();
        pool.add(object);
    }
}
