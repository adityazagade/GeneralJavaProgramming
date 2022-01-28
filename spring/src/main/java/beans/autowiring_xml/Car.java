package beans.autowiring_xml;

public class Car {
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void printData() {
        System.out.println("EngineModelYear " + engine.getModelYear());
    }

}
