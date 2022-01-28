package design.creational.abstractFactory.example1;

public class GoogleInstanceImpl implements Instance {
    Capacity capacity;
    Storage storage;

    public GoogleInstanceImpl(Capacity capacity) {
        this.capacity = capacity;
    }

    @Override
    public void attachStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void start() {
        System.out.println("Google Server Started");
    }

    @Override
    public void stop() {
        System.out.println("Google Server Stopped");
    }
}
