package week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindTheMedian {
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
    public static void sort(List<Integer> a, int low, int high) {
        if (high <= low) return;
        int i = partition(a, low, high);
        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }

    public static int findMedian(List<Integer> arr) {
        sort(arr,0,arr.size()-1);
        return arr.get((int) arr.size()/2);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();//1 3 9 8 2 7 5
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(findMedian(arr));
    }
}
