package week5;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class Queue<Item> {
    private StackSetUpLlist<Item> input = new StackSetUpLlist<>();
    private StackSetUpLlist<Item> output = new StackSetUpLlist<>();
    private int size = 0;


    public void enqueue(Item item) {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        input.push(item);
        while (!output.isEmpty()) {
            input.push(output.pop());
        }
        size++;
    }

    public void dequeue() {
        if (input.isEmpty())
        {
            System.out.println("Underflow!!");
            System.exit(0);
        }
        input.pop();
    }

    public Item top() {
        return input.top();
    }
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Queue<Integer> st = new Queue<Integer>();
        st.enqueue(1);
        st.enqueue(2);
        st.enqueue(3);
        while (st.top() != null) {
            StdOut.println(st.top());
            st.dequeue();
        }
    }
}
