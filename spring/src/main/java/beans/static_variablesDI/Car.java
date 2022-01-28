package beans.static_variablesDI;

public class Car {
    private static String carName;

    public static void setCarName(String carName) {
        Car.carName = carName;
    }

    public static void printCar() {
        System.out.println("CarName " + carName);
    }
}
