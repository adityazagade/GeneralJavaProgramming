package beans.c_namespace;

public class Car {
    private Engine e;
    private String carName;

    public Car(Engine e, String carName) {
        this.e = e;
        this.carName = carName;
    }

    public void printCarInfo() {
        System.out.println(this.carName);
    }
}
