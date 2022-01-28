import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class linkedHashMap {
    public static void main(String[] args) {
        // define a linked hash map
        Map<String, String> lhm = new LinkedHashMap<>();

        //adding element to linked hash map
        lhm.put("Aditya", "Zagade");
        lhm.put("Martin", "Garrix");
        lhm.put("Chandler", "Bing");
        lhm.put("Monica", "Geller");
        lhm.put("Ross", "Geller");

        //iterate over map (1st way).
        // must be used when you need keys only.
        Iterator<String> it = lhm.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = lhm.get(key);
            System.out.println("key: " + key + ", value: " + value);
        }

        System.out.println("===== 2nd way ========");
        //iterate over map(2nd way)
        lhm.forEach((k, v) -> {
            System.out.println("key: " + k + ", value: " + v);
        });

        System.out.println("===== 3nd way ========");
        System.out.println("when you need values only");
        lhm.values().forEach(System.out::println);

        System.out.println("using entryset");
        lhm.entrySet().forEach((e) -> {
            System.out.println(e.getKey() + ": " + e.getValue());
        });

        //if you want to remove entries during mid iteration, then you should go with iterator.
        Iterator it1 = lhm.entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry pair = (Map.Entry) it1.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
}
