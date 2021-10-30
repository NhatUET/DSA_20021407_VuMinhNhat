package week8;

public class HeapSort {
    public static void sink(int[] a, int i, int j) {
        while (2 * i <= j) {
            int k = 2 * i;
            if (k < j && less(a[k], a[k+1])) j++;
            if (!less(a[i], a[k])) break;
            exch(a, i, k);
            i = k;
        }
    }

    public static void exch(int[] a, int i, int j) {
        int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
    }

    public static void sort(int[] a) {
        int size = a.length;
        for (int i = size/2; i >= 1; i--) sink(a, 1, size);
        while (size > 1) {
            exch(a, 1, size);
            sink(a, 1, --size);
        }
    }

    public static boolean less(int i, int j) {
        return i < j;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9,8,6,4,2};
        sort(a);
        for (int i : a) System.out.print(i + " ");
    }
}
