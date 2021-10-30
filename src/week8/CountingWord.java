package week8;
import java.util.Set;
import java.util.TreeMap;

public class CountingWord {
    public static void Count(String s) {
        TreeMap<String, Integer> mp = new TreeMap<String, Integer>();
        String[] words = s.split("\\s+");
        String K = "";
        Integer V;
        for (String word : words) {
            K = word;
            if (mp.containsKey(K)) {
                V = mp.get(K);
                mp.remove(K);
                mp.put(K, V + 1);
            } else {
                mp.put(K, 1);
            }
        }
        Set<String> keySet = mp.keySet();
        for (String key : keySet) {
            System.out.println(key + " : " + mp.get(key));
        }
    }
    public static void main(String[] args) {
        String s = "i love you so so much i love much";
        Count(s);
    }
}
