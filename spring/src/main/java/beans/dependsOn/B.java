package beans.dependsOn;

public class B {
    private C c;

    public void setC(C c) {
        this.c = c;
    }

    public B() {
        System.out.println("B Constructor called");
    }
}
