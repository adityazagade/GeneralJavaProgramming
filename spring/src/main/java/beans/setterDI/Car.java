package beans.setterDI;

public class Car {
    private Engine e;
    private String carName;

    public void setE(Engine e) {
        this.e = e;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
