package design.creational.abstractFactory.example1;

public interface ResourceFactory {
    public Instance createInstance(Capacity capacity);
    public Storage createStorage(int size);
}
