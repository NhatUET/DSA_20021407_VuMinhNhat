package w2;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class ThreeSum {
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
