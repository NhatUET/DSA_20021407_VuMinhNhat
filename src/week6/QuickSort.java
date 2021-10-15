package week6;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
/*
    best case: chia ra được tối ưu luôn ( bên phải key luôn lớn hơn key và ngược lại) -> O(NLogN)
    worst case: dãy đã đc tăng dần, key ở đầu, ->  O(n^2)
    complexity: O(n^2)
 */
public class QuickSort {
    public static boolean smaller(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }
    public static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static int partition(Comparable[] a, int low, int high) {
        int i = low, j = high + 1;
        while (true) {
            while (!smaller(a[++i], a[low])) {
                if (i == high) break;
            }
            while (!smaller(a[low], a[--j])) {
                if (j == low) break;
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }

    public static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }
    public static void quickSort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        In in = new In("D:\\algs4-data\\4Kints.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts();  // đọc toàn bộ file vào mảng a
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();  // thời gian chạy bằng end - start
        System.out.print(end - start); // in mảng ra màn hình
    }
}
