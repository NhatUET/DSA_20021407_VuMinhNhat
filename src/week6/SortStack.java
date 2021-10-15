package week6;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
    sx s1 tang dan -> sx s2 giam dan.
 */
public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int temp;
        int[] a = {5, 3 ,4 , 1, 2};
        for (int x : a) s1.push(x);
        while (!s1.isEmpty()) {
            temp = s1.pop();
            while (!s2.isEmpty() && s2.peek() > temp) {
                s1.push(s2.pop()); // chuyen tat ca cac phan tu lon hon temp tu s2 sang s1.
            }
            s2.push(temp);
        }

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        while (!s1.isEmpty()) {
            StdOut.print(s1.pop() + " ");
        }
    }
}
