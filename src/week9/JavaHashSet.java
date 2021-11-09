package week9;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashSet {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pairLeft = new String[t];
        String [] pairRight = new String[t];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < t; i++) {
            pairLeft[i] = s.next();
            pairRight[i] = s.next();
        }
        for (int i = 0; i < t; i++) {
            String res = pairLeft[i] + " " + pairRight[i];
            set.add(res);
            System.out.println(set.size());
        }
    }
}
