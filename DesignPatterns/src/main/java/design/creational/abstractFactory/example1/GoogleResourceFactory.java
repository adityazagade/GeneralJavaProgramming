package design.creational.abstractFactory.example1;

public class GoogleResourceFactory implements ResourceFactory {
    public Instance createInstance(Capacity capacity) {
        return new GoogleInstanceImpl(capacity);
    }

    public Storage createStorage(int size) {
        return new GoogleStorageImpl(size);
    }
}
