package ImportStatement;

public class Main3 {
    /*
     * java.lang package is always available. No import statement required.
     * default package
     * */
    public static void main(String[] args) {
        Thread t = new Thread();
        StringBuffer sb = new StringBuffer();
        String a = "";

        // coming from same package/
        Main1 m = new Main1();

        // code compiles. No problem

    }
}
