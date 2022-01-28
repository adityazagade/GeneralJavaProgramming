package design.creational.abstractFactory.example1;

public class AWSInstanceImpl implements Instance {
    Storage storage;
    Capacity capacity;

    public AWSInstanceImpl(Capacity capacity) {
        this.capacity = capacity;
    }

    @Override
    public void attachStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void start() {
        System.out.println("AWS Server Started");
    }

    @Override
    public void stop() {
        System.out.println("AWS Server Stopped");
    }
}
