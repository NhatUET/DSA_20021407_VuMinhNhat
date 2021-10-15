package week5;

import java.util.Iterator;
import java.util.List;

public class StackSetUpLlist<Item> implements Iterable<Item> {
    private Node<Item> first = null;
    private int size = 0;
    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node<Item> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (hasNext()) {
                    Item item = current.item;
                    current = current.next;
                    return item;
                } else {
                    return null;
                }
            }
        };
    }


    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public Item top() {
        if (first == null) {
            return null;
        } else {
            Item item = first.item;
            return item;
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    public static void main(String[] args) {
        StackSetUpLlist<String> s = new StackSetUpLlist<>();
        s.push("A");
        s.push("B");
        s.push("C");
        System.out.println("Stack: " + s);

        s.pop();
        System.out.println("Stack: " + s);
        s.pop();
        System.out.println("Stack: " + s);

        s.push("D");
        System.out.println("Stack: " + s);
    }
}

