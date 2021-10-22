package week7;

import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort1 {
    public static int partition(List<Integer> a, int low, int high) {
        int i = low, j = high + 1;
        while (true) {
            while (a.get(++i) < a.get(low)) {
                if (i == high) break;
            }
            while (a.get(low) < a.get(--j)) {
                if (j == low) break;
            }
            if (i >= j) break;
            Collections.swap(a, i, j);
        }
        Collections.swap(a, low, j);
        return j;
    }
    public static List<Integer> quickSort(List<Integer>a) {
        partition(a, 0, a.size()-1);
        return a;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);arr.add(5);arr.add(3);arr.add(7);arr.add(2);
        quickSort(arr);
        System.out.print(arr);
    }
}
