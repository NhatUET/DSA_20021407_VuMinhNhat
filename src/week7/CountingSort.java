package week7;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> res = new ArrayList<Integer>(100);
        int[] a = new int[101];
        for (int i = 0; i < arr.size(); i++) {
            a[arr.get(i)]++;
        }
        for (int i = 1; i <= 100; i++) {
            res.add(a[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.print(countingSort(a));
    }
}
