package beans.singleton;

import sun.plugin.dom.exception.InvalidAccessException;

public class Test {
    private static Test test;

    public static Test getTest() {
        if (test == null) {
            test = new Test();
        }
        return test;
    }

    private Test() {
        System.out.println("Private Test Constructor");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new InvalidAccessException("Invalid access on test class");
    }
}
