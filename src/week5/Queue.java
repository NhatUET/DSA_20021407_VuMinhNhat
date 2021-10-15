package week5;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class Queue<Item>  {
    private StackSetUpLlist<Item> input = new StackSetUpLlist<>();
    private StackSetUpLlist<Item> output = new StackSetUpLlist<>();
    private int size = 0;


    public void enqueue(Item item) {
        input.push(item);
        size++;
    }

    public void dequeue() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        output.pop();
        size--;
    }

    public Item top() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.top();
    }
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Queue<Integer> st = new Queue<Integer>();
        StdOut.println("before");
        st.enqueue(1);
        st.enqueue(2);
        st.enqueue(3);
        StdOut.println(st.size());
        while (st.top() != null) {
            StdOut.print(st.top() + " ");
            st.dequeue();
        }

        st.enqueue(1);
        st.enqueue(2);
        st.enqueue(3);
        st.enqueue(4);
        StdOut.println();
        StdOut.println("after");
        StdOut.println(st.size());
        while (st.top() != null) {
            StdOut.print(st.top() + " ");
            st.dequeue();
        }

    }
}
