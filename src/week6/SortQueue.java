package week6;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class SortQueue {
    public static void main(String[] args) {
        Queue<Integer> s1 = new Queue<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        int temp;
        int[] a = {5, 3 ,4 , 1, 2};
        for (int x : a) s1.enqueue(x);

        while (!s1.isEmpty()) {
            temp = s1.dequeue();
            while (!s2.isEmpty() && s2.peek() < temp) {
                s1.enqueue(s2.pop());
            }
            s2.push(temp);
        }

        while (!s2.isEmpty()) {
            s1.enqueue(s2.pop());
        }

        while (!s1.isEmpty()) {
            System.out.print(s1.dequeue() + " ");
        }
    }
}
