package week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuickSortInPlace {
    public static int partition(List<Integer> a, int low, int high) {
        int pivot = a.get(high);
        int i = low;
        for (int j = low; j < high; j++) {
            if (a.get(j) < pivot) {
                Collections.swap(a, i, j);
                i++;
            }
        }
        Collections.swap(a, i, high);
        for (int j = 0; j < a.size(); j++) {
            System.out.print(a.get(j) + " ");
        }
        System.out.println();
        return i;
    }
    public static void sort(List<Integer> a, int low, int high) {
        if (high <= low) return;
        int i = partition(a, low, high);
        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();//1 3 9 8 2 7 5
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        sort(arr, 0, arr.size()-1);
    }
}
