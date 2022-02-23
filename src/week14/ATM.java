package week14;

import java.util.Scanner;

public class ATM {
    static int minAmount(int[] v, int w) {
        int[] dp = new int[w + 1];
        dp[0] = 0;
        for (int i = 1; i <= w; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 0; j < v.length; j++) {
                if (i >= v[j]) {
                    int res = dp[i-v[j]];
                    if (res != Integer.MAX_VALUE) {
                        count = Math.min(count, res+1);
                    }
                }
            }
            dp[i] = count;
        }
        return dp[w] == Integer.MAX_VALUE ? -1 : dp[w];
    }

    public static void main(String[] args) {
        int[] v = new int[] {1, 2, 5, 10,50};
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        System.out.print(minAmount(v,w));
    }
}
