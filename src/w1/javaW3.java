package w1;

import edu.princeton.cs.algs4.EulerianCycle;

import java.awt.*;

public class javaW3 {
    //27
    public static void draw(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; i < n; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    //32
    public static void ramanujan(int N) {
        int n = N;
        for (int a = 1; a <= n; a++) {
            int a3 = a * a * a;
            if (a3 > n) break;
            for (int b = a; b <= n; b++) {
                int b3 = b * b * b;
                if (a3 + b3 > n) break;

                for (int c = a + 1; c <= n; c++) {
                    int c3 = c * c * c;
                    if (c3 > a3 + b3) break;

                    for (int d = c; d <= n; d++) {
                        int d3 = d * d * d;
                        if (c3 + d3 > a3 + b3) break;

                        if (c3 + d3 == a3 + b3) {
                            System.out.print((a3+b3) + " = ");
                            System.out.print(a + "^3 + " + b + "^3 = ");
                            System.out.print(c + "^3 + " + d + "^3");
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
    //44
    public static void Euler(long N) {
        long n = N;
        long a5, b5, c5, d5, e5;

        for (long e = 1; e <= n; e++) {
            e5 = e*e*e*e*e;
            for (long a = 1; a <= n; a++) {
                a5 = a * a * a * a * a;
                if (a5 + a5 + a5 + a5 > e5) break;

                for (long b = a; b <= n; b++) {
                    b5 = b * b * b * b * b;
                    if (a5 + b5 + b5 + b5 > e5) break;

                    for (long c = b; c <= n; c++) {
                        c5 = c * c * c * c * c;
                        if (a5 + b5 + c5 + c5 > e5) break;

                        for (long d = c; d <= n; d++) {
                            d5 = d * d * d * d * d;
                            if (a5 + b5 + c5 + d5  > e5) break;
                            if (a5 + b5 + c5 + d5 == e5)
                                System.out.println(a + "^5 + " + b + "^5 + " + c + "^5 + " + d + "^5 = " + e + "^5");
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int n = 10;
        long m = 124;
        int k = 100;
        Euler(m);
        draw(n);
        ramanujan(k);
    }
}
