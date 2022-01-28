package beans.ArrayDI;

public class Cars {
    private Engine[] engines;
    private String[] carNames;

    public Engine[] getEngines() {
        return engines;
    }

    public void setEngines(Engine[] engines) {
        this.engines = engines;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public void setCarNames(String[] carNames) {
        this.carNames = carNames;
    }

    public void printCarData(){
        for (int i = 0; i < engines.length; i++) {
            System.out.println(engines[i].getModelYear());
        }
        for (int i = 0; i < carNames.length; i++) {
            System.out.println(carNames[i]);
        }
    }
}
