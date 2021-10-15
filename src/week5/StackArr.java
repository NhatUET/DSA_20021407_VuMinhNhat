package week5;

public class StackArr {
    private int[] arr;
    private int size = 0;

    public StackArr(int cap) {
        arr = new int[cap];
    }

    public void resize(int n) {
        arr = new int[n];
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(int data) { // push: O(n)
        if (size == arr.length-1) resize(2 * size);
        if (size < arr.length) {
            arr[size++] = data;
        }
    }

    public void pop() { // pop: O(n)
        size--;
        if (size > 0 && size == arr.length/4) resize(arr.length/2);
    }

    public int top() { // O(1)
        if (!isEmpty()) {
            return arr[size-1];
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        StackArr s = new StackArr(2);
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
