import java.util.ArrayList;

public class TestList {
    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<>();
        test.add("a");
        test.add("b");
        test.add("c");
        test.add("d");
        test.add("e");
        test.add("f");
        test.add("g");
        test.add("h");
        test.add("a");
        test.add("b");
        test.add("c");
        test.add("d");
        test.add("e");
        test.add("f");
        test.add("g");
        test.add("h");
        test.add("a");
        test.add("b");
        test.add("c");
        test.add("d");
        test.add("e");
        test.add("f");
        test.add("g");
        test.add("h");
        System.out.println("size " + test.size());
        ArrayList<String> removeList = new ArrayList<>();
        removeList.add("a");
        test.removeAll(removeList);
        System.out.println("size " + test.size());
    }
}
