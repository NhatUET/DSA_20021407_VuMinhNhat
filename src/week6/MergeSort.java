package week6;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
/*
    O(NlogN)
    time : 15
 */
public class MergeSort {
    public static boolean smaller(int a, int b) {
        return a - b < 0;
    }

    public static void merge(int[] a, int[] b, int low, int mid,int high) {
        for (int k = low; k <= high; k++) {
            b[k] = a[k];
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = b[j++];
            else if (j > high) a[k] = b[i++];
            else if (smaller(b[j], a[i])) a[k] = b[j++];
            else a[k] = b[i++];
        }
    }

    public static void sort(int[] a, int[] b, int low,int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(a,b,low,mid);
        sort(a,b, mid + 1, high);
        merge(a, b, low, mid, high);
    }

    public static void Mergesort(int[] a) {
        int[] b = new int[a.length];
        sort(a, b, 0, a.length - 1);
    }
    public static void main(String[] args) {
        In in = new In("D:\\algs4-data\\4Kints.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts();  // đọc toàn bộ file vào mảng a
        long start = System.currentTimeMillis();
        // xử lý dữ liệu trong mảng a
        Mergesort(a);
        long end = System.currentTimeMillis();  // thời gian chạy bằng end - start
        System.out.print(end - start); // in mảng ra màn hình
    }
}
