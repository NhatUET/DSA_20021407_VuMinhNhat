package week5;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        String s = "";
        Stack<String> history = new Stack<>();
        N = sc.nextInt();
        while (N-- > 0) {
            int choose;
            choose = sc.nextInt();
            if (choose == 1) {
                String input;
                input = sc.next();
                history.push(s);
                s += input;
            } else if (choose == 2) {
                int input;
                input = sc.nextInt();
                history.push(s);
                s.substring(0, s.length() - input);
            } else if (choose == 3) {
                int input;
                input = sc.nextInt();
                System.out.println(s.charAt(input-1));
            } else if (choose == 4) {
                s = history.peek();
                history.pop();
            }
        }
    }
}
