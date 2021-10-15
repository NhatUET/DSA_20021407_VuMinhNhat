package week5;

import org.w3c.dom.events.EventException;

public class StackLinked {
    private Node first;
    private int size = 0;

    private class Node {
        int value;
        Node next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int value) { //o(1)
        Node oldFirst = first;
        first = new Node();
        first.value = value;
        first.next = oldFirst;
        size++;
    }

    public void pop() {  // O(1)
        if (!isEmpty()) {
            first = first.next;
            size--;
        }
    }

    public int top() { // O(1)
        if (size == 0) return -1;
        else return first.value;
    }

    public int size() {
        return size;
    }
    public static void main(String[] args) {
        StackLinked s = new StackLinked();
        s.push(1);
        s.push(2);
        System.out.println("Stack: " + s.top());
        s.push(3);
        System.out.println("Stack: " + s.top());

        s.pop();
        System.out.println("Stack: " + s.top());
        s.pop();
        System.out.println("Stack: " + s.top());
        s.pop();
        System.out.println("Stack: " + s.top());
        s.push(4);
        System.out.println("Stack: " + s.top());
    }
}
