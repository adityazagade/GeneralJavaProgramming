package beans.setterDIchecking;

public class Car {
    private Engine engine;
    private String carName;

    public void setE(Engine e) {
        this.engine = e;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
