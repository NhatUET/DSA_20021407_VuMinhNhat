package week5;

import java.util.Iterator;
import java.util.List;

public class StackSetUpLlist<Item> implements Iterable<Item> {
    private Node first = null;
    private int size = 0;
    private class Node {
        Item item;
        Node next;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current == null;
        }

        @Override
        public Item next() {
            if (current == null) return null;
            else {
                Item item = current.item;
                current = current.next;
                return item;
            }

        }
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
}

