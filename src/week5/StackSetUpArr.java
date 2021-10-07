package week5;

import javax.swing.tree.FixedHeightLayoutCache;
import java.util.Iterator;

public class StackSetUpArr<Item> implements Iterable<Item> {
    private Item[] s;
    private int N = 0;

    public StackSetUpArr(int n) {
        s = (Item[]) new Object[n];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public void push(Item item) {
        s[N++] = item;
    }
    public Item pop() {
        return s[--N];
    }
    public Iterator<Item> iterator() {
        return null;
    }
}
