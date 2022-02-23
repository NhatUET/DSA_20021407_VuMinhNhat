package week14;

import java.util.Scanner;

public class Knapsack {
    static int max(int a, int b) {
        return Math.max(a, b);
    }

    static int count(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i - 1] <= j)
                    dp[i][j] = max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

       // System.out.print(count(m, a, n));
    }
}
