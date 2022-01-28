import org.apache.commons.beanutils.ConvertUtils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> l = new ArrayList<>();
        l.add("a");
        l.add("b");
        l.add("c");
        l.add("d");
        System.out.println(l.toString());
//        String lString = l.toString().replace("[", "(").replace("]", ")");
//        System.out.println(l.toString());
//        System.out.println(lString);
        System.out.println(ConvertUtils.convert(l));
//        for (int i = 0; i < 1000; i++) {
//            System.out.println("i: " + i + " : " + getTimeoutLong(i));
//        }
//        System.out.println((Long.MAX_VALUE/(60*60*1000)));
//        System.out.println((Long.MAX_VALUE%(60*60*1000)));
//        System.out.println((Integer.MAX_VALUE/(60*60*1000)));
//        System.out.println(getTimeout(595));
//        System.out.println(getTimeout(596));
//        System.out.println(getTimeout(597));
    }

    private static long getTimeout(int i) {
        return (i * 60 * 60 * 1000);
    }

    private static long getTimeoutLong(long i) {
        return (i * 60 * 60 * 1000);
    }
}
