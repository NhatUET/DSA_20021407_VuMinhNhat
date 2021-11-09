package week9;

import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JavaMap {
    static Map<String, Integer> people = new HashMap<>();
    public static void findPeople(String name) {
        Set<String> set = people.keySet();
        if (set.contains(name)) {
            System.out.println(name + ": " + people.get(name));
        } else {
            System.out.println("Not found");
        }
    }

    public static void main(String[] args) {
        people.put("nhat", 123123132);
        people.put("hang",123132);
        findPeople("nhat");
    }
}
