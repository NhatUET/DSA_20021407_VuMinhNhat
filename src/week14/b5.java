package week14;

public class b5 {
    static int tknp(int[] N, int lo, int hi, int k) {
        while (lo < hi) {
            int m = lo + (hi - lo) / 2;
            if (N[m] == k) return m;
            else if (N[m] < k) {
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }
        return hi;
    }

    public static void main(String[] args) {
        int[] N = {3,5,9,11};
        int[] M = {6, 1, 9,12};
        for (int i = 0; i < M.length; i++) {
            if (M[i] < N[0]) System.out.print(-1 + " ");
            else if (M[i] > N[N.length-1]) System.out.print(N[N.length-1] + " ");
            else System.out.print(N[tknp(N, 0, N.length-1, M[i])] + " ");
        }
    }
}
