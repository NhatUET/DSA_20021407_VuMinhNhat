package week14;

import java.util.Arrays;

public class LIS {
    static int[] a;
    static int LongestIncreasingSub(int[] a) {
        if (a.length <= 1) return a.length;
        int[] dp = new int[a.length];
        int max = Integer.MIN_VALUE;
        Arrays.fill(dp,1);
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        a = new int[] {10, 9, 2, 5, 3, 7, 101, 2};
        System.out.print(LongestIncreasingSub(a));
    }
}

