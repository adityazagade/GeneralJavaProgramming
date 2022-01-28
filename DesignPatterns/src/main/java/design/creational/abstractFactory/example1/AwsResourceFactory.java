package design.creational.abstractFactory.example1;

public class AwsResourceFactory implements ResourceFactory {
    public Instance createInstance(Capacity capacity) {
        return new AWSInstanceImpl(capacity);
    }

    public Storage createStorage(int size) {
        return new AWSStorageImpl(size);
    }
}
