package week3;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;
import java.util.Random;

public class binarySearch {
    public static int binSearch(int[] a, int number, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (a[mid] > number){
            return binSearch(a, number, low, mid - 1);
        }
        if (a[mid] < number){
            return binSearch(a, number, mid + 1, high);
        }
        if (a[mid] == number) {
            return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            Random rand = new Random();
            int ranNum = rand.nextInt(100);
            arr[i] = ranNum;
        }
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        System.out.println(binSearch(arr, 10, low, high));
    }
}
