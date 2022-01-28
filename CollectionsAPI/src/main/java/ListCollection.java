import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListCollection {
    public static void main(String[] args) {
        /* Let us learn more about list
         * 1. List is an interface.
         * 2. Child interface of Collection interface.
         * 3. Index plays an important part of List.
         * 4. Insertion Order is maintained and duplicates are allowed.
         * */
        /* Let us discuss important methods from Collection interface */
        List l = new ArrayList<String>();
        l.add("A");

        List l1 = new ArrayList();
        l1.add("B");
        l1.add("C");
        l.addAll(l1);


        List l2 = new ArrayList();
        l2.add("B");
        l2.add("C");
        l.remove("A");
        l.removeAll(l2);

        l.add("A");
        l.add("B");
        l.add("C");
        l.add("D");
        l.add("E");
        l.retainAll(l2);

        l.containsAll(l2);
        l.contains("B");

        l.isEmpty();

        l.size();

        l.toArray();

        // get an iterator over a collection
        Iterator it = l.iterator();


        // List specific methods
        List l3 = new ArrayList();
        l3.add(0,l);
        l3.add(1,"C"); // add at specific index.

        l3.get(1);
        l3.remove(1);
        l3.set(0,"D");
        l3.indexOf("D");
        l3.lastIndexOf("D");
        ListIterator lIt = l.listIterator();

        /*IMP: You cannot add/set anything in list in index >= than its size.*/
    }
}
