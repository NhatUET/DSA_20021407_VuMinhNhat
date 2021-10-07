package week5;

import edu.princeton.cs.algs4.StdOut;

public class SelectionSort {
    public static boolean smaller(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }
    public static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (smaller(a[min], a[j])) {
                    min = j;
                }
            }
            swap(a,i,min);
        }
    }
    public static void main(String[] args) {
        Comparable[] a = {1, 3, 5 , 2 , 4, 10};
        long start = System.currentTimeMillis();
        sort(a);
        long end = System.currentTimeMillis();
        StdOut.println(end-start);
    }
}