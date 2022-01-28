package beans.factory_instance;

public class CarFactory {
    public String carName;

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Car getInstance() throws Exception {
        Honda c = (Honda) Class.forName(carName).newInstance();
        return c;
    }
}
