package week11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pair {
    public static int pairs(int k, List<Integer> arr) {
        int count = 0;
        Set<Integer> res = new HashSet<>(arr);
        for (Integer integer : arr) {
            if (res.contains(integer + k)) count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
