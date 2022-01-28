package design.creational.prototype;

public class Sheep implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Sheep sheep = (Sheep) super.clone();
        sheep.initialize();
        return sheep;
    }

    protected void initialize() {
        this.name = "";
    }
}
