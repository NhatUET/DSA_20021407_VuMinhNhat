package week7;

import edu.princeton.cs.algs4.Queue;

import java.util.Collections;

public class PriorityQueue {
    int[] a;
    int size = 0;

    public PriorityQueue(int capacity) {
        a = new int[capacity];
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int value) {
        a[size++] = value;
    }

    public int delMax() {
        int maxQ = a[0];
        for (int i = 0; i < size; i++) {
            if (maxQ < a[i]) {
                maxQ = i;
            }
        }
        int tmp = a[maxQ];
        a[maxQ] = a[size-1];
        a[size-1] = tmp;
        return a[--size];
    }

    public int delMin() {
        int minQ = a[0];
        for (int i = 0; i < size; i++) {
            if (minQ > a[i]) {
                minQ = i;
            }
        }
        int tmp = a[minQ];
        a[minQ] = a[size-1];
        a[size-1] = tmp;
        return a[--size];
    }

    public static void main(String[] args) {
        PriorityQueue p = new PriorityQueue(3);
        p.insert(3);
        p.insert(4);
        p.insert(5);
        System.out.println(p.delMax());
    }
}
