package week14;

public class ATM {
    static int minAmount(int[] v, int w) {
        int[][] dp = new int[v.length][w + 1];
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = 0;
            }
        }
        for (int j = 1; j <= w; j++) {
            dp[1][j] = v[1];
        }

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < v[i]) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i][j-v[i]] + 1);
                }
            }
        }
        return dp[v.length-1][w];
    }

    public static void main(String[] args) {
        int[] v = new int[] {0, 1, 2, 5, 10,50};
        int w = 100;
        System.out.print(minAmount(v,w));
    }
}
