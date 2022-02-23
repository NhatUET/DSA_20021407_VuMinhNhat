package week14;

import java.util.Scanner;

public class newtesst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (i - arr[j-1] >= 0) {
                    dp[i][j] = Math.max(dp[i - arr[j-1]][j-1] + arr[j-1], dp[i][j-1]);
                } else dp[i][j] = dp[i][j-1];
            }
        }
        System.out.print(dp[m][n]);
    }
}
