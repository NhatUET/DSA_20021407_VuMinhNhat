package week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class EqualStack {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();
        int height = 0;
        // cong cuon chieu
        for (int i = h1.size() - 1; i >= 0; i--) {
            if (st1.isEmpty()) st1.push(h1.get(i));
            else {
                st1.push(h1.get(i) + st1.peek());
            }
        }


        for (int i = h2.size() - 1; i >= 0; i--) {
            if (st2.isEmpty()) st2.push(h2.get(i));
            else {
                st2.push(h2.get(i) + st2.peek());
            }
        }
        for (int i = h3.size() - 1; i >= 0; i--) {
            if (st3.isEmpty()) st3.push(h3.get(i));
            else {
                st3.push(h3.get(i) + st3.peek());
            }
        }
        // devide top
        while (!st1.isEmpty() && !st2.isEmpty() && !st3.isEmpty()) {
            if (st1.peek() == st2.peek() && st2.peek() == st3.peek()) return st1.peek();
            else if (st1.peek() > st2.peek() || st1.peek() > st3.peek()) st1.pop();
            else if (st2.peek() > st1.peek() || st2.peek() > st3.peek()) st2.pop();
            else if (st3.peek() > st1.peek() || st3.peek() > st2.peek()) st3.pop();
        }
        return height;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> h1 = new ArrayList<>(){};
        List<Integer> h2 = new ArrayList<>(){};
        List<Integer> h3 = new ArrayList<>(){};
        for (int i = 0; i < 5; i++) h1.add(sc.nextInt());
        for (int i = 0; i < 3; i++) h2.add(sc.nextInt());
        for (int i = 0; i < 4; i++) h3.add(sc.nextInt());
        System.out.print(equalStacks(h1,h2,h3));
    }
}
