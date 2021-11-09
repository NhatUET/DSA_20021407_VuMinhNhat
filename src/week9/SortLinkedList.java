package week9;

import week4.compare2Llist;
import week7.PriorityQueue;

import java.io.BufferedWriter;
import java.io.IOException;

public class SortLinkedList {
    static class Node {
        public int data;
        public Node next;

        public Node() {}
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class linkedList {
        public Node head;
        public Node tail;

        public linkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            Node node = new Node(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printLL(linkedList ll) {
        while (ll.head.next != null) {
            System.out.print(ll.head.data + " ");
            ll.head = ll.head.next;
        }
    }

    public static Node getMid(Node head) {
        Node p = head;
        Node q = head;
        while (p.next!= null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
        }
        Node mid = q.next;
        q.next = null;
        return mid; // n/2
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node head1 = getMid(head);
        head = mergeSort(head);
        head1 = mergeSort(head1);
        return merge(head, head1);  //logn.n/2
    }
    public static Node merge(Node a, Node b) {
        if (a == null || b == null) return (a == null) ? b : a;
        if (a.data > b.data) {
            b.next = merge(a, b.next);
            return b;
        } else {
            a.next = merge(a.next, b);
            return a;
        } // n
    }
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 4 , 5, 9, 10, 1, 3, 2};
        linkedList ll = new linkedList();
        for (int j : a) {
            ll.insertNode(j);
        }
        ll.head = mergeSort(ll.head);
        printLL(ll);
    }
}
