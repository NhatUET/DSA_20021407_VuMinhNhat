package week3;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class threeSum {
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
        In in = new In("D:\\algs4-data\\1Kints.txt");
        int[] arr = in.readAllInts();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            int high = arr.length-1;
            int low = i+1;

            while (low < high){
                if(arr[i] + arr[low] + arr[high] < 0){
                    low++;
                } else if(arr[i] + arr[low] + arr[high] > 0){
                    high--;
                } else {
                    System.out.println(arr[i] + " " + arr[low] + " " + arr[high]);
                    low++;
                    high--;
                }
            }
        }
    }
}
