package beans.dependsOn;

public class C {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public C() {
        System.out.println("C Constructor called");
    }
}
