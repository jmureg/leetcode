import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.size();

        Stack<String> h = new Stack<String>();

        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1,  "A");
        hashtable.put(2,  "B" );
        hashtable.put(3,  "C");
        hashtable.put(2,  "BB" );
        String test = hashtable.get(2);
        System.out.println(hashtable);

        HashMap<Integer, String> hmap1 = new HashMap<Integer, String>();
        hmap1.put(1, "Auto");
        hmap1.containsKey("");

        HashMap<String, Integer> hmap2 = new HashMap<String, Integer>();
        hmap2.put("Auto", 1);

        LinkedList<String> linkedlist = new LinkedList<String>();
        linkedlist.size();
    }
}
