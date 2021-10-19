package week6;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.StdOut;
/*
    Insertion sort:
    worse case:
        mang sap xep giam dan: moi lan chay mat i lan swap -> N lan chay thi mat N(N-1)/2 -> O(N^2)
    best case:
        da sap xep tang dan: chay tu dau den cuoi -> mat N-1 lan -> O(N)
    -> O(N^2)
    time: 15
 */
public class InsertionSort {
    public static boolean smaller(int a, int b) {
        return a - b > 0;
    }
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (!smaller(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        In in = new In("D:\\algs4-data\\4Kints.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts();  // đọc toàn bộ file vào mảng a
        long start = System.currentTimeMillis();
        sort(a);
        long end = System.currentTimeMillis();  // thời gian chạy bằng end - start
        System.out.print(end - start); // in mảng ra màn hình
    }
}
