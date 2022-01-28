package beans;

public class Test_privateCons {

    private Test_privateCons() {
        System.out.println("Private Constructor called");
    }

    public void hello(){
        System.out.println("Hello there!");
    }

}
