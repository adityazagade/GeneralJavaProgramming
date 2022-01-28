package beans.dependsOn;

public class A {
    private B b;

    public void setB(B b) {
        this.b = b;
    }

    public A() {
        System.out.println("A Constructor called");
    }
}
