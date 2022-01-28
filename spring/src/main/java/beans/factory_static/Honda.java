package beans.factory_static;

public class Honda implements Car {
    @Override
    public void drive() {
        System.out.println("Honda Car driving");
    }
}
