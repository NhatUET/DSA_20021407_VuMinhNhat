package week3;
import edu.princeton.cs.algs4.In;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SerlockAndArr {
    // O(n)
    public static String balancedSums(List<Integer> arr) {
        int left = 0;
        int sum = 0;
        for (int element : arr) sum+=element;
        for (int f_num : arr) {
            if (2 * left == sum - f_num) {
                return "YES";
            } else {
                left += f_num;
            }
        }
        return "NO";
    }
    //O(n^2)
    public static int SumLeft(List<Integer> arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
        }
        return sum;
    }

    public static String rbalancedSums(List<Integer> arr) {
        int sumArr = 0;
        for (int element : arr) sumArr += element;
        for(int i = 0; i < arr.size(); i++) {
            int sL = SumLeft(arr,i);
            if (2 * sL == sumArr - arr.get(i)) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(3);
        for (Integer x:arr) System.out.print(x + " ");
        System.out.println(rbalancedSums(arr));
        System.out.println(SumLeft(arr,3));
    }
}
