package beans.autowiring_xml;

public class Bus {
    private Engine engine;

//    public Bus() {
//        System.out.println("Default bus constructor");
//    }

    public void setEngine(Engine engine) {
        System.out.println("Setter");
        this.engine = engine;
    }

    public Bus(Engine engine) {
        this.engine = engine;
    }

    public void printData() {
        System.out.println("EngineModelYear " + engine.getModelYear());
    }
}
