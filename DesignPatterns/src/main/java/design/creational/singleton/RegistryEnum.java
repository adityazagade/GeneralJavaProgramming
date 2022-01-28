package design.creational.singleton;

//Since Java 1.5, we can use enum to create singleton. It handles serialization using java's in-built
// mechanism and still ensure single instance;
public enum RegistryEnum {
    INSTANCE;

    // other methods you wanted to add
    public void getConfiguration(){

    }
}
