package week6;

import java.util.List;

public class InsertionSortPart2 {
    public static boolean smaller(int a, int b) {
        return a - b > 0;
    }
    public static void swap(List<Integer> a, int i, int j) {
        int tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }
    public static void print(List<Integer> arr) {
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();
    }
    public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (!smaller(arr.get(j), arr.get(j - 1))) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
            print(arr);
        }
    }
}
