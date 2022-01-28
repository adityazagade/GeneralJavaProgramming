package beans.p_namespace;

public class Car {
    private Engine e;
    private String carName;

    public void setE(Engine e) {
        this.e = e;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void printCarInfo(){
        System.out.println(this.carName);
    }
}
