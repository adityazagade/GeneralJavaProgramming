package beans.factory_instance;

public class Honda implements Car {
    @Override
    public void drive() {
        System.out.println("Honda Car driving");
    }
}
