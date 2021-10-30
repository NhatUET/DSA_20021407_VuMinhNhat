package week8;

import java.util.Scanner;

public class StringReverse {
    public static boolean check(String s) {
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) res += s.charAt(i);
        if (s.equals(res)) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        System.out.println(check(A) ? "Yes" : "No");
    }
}
