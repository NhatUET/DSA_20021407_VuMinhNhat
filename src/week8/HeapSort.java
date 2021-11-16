package week8;

public class HeapSort {
    public static int[] a = null;
    public HeapSort(int s) {
        a = new int[s];
    }
    public static void sink(int i, int j) {
        if (a.length > 0) {
            while (2 * i <= j) {
                int k = 2 * i;
                if (k < j && less(a[k], a[k+1])) j++;
                if (!less(a[i], a[k])) break;
                exch(i, k);
                i = k;
            }
        }
    }

    public static void exch( int i, int j) {
        int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
    }

    public static void sort(int[] a) {
        int size = a.length;
        for (int i = size/2; i >= 1; i--) sink(i, size);
        while (size > 1) {
            exch(1, size);
            sink(1, --size);
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
