package week5;
//FIFO
public class QueueArr {
    public int[] arr;
    public int size = 0;

    public QueueArr(int n) {
        arr = new int[n];
    }

    public void resize(int n) {
        arr = new int[n];
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int data) { // o(n)
        if (size == arr.length) resize(2 * size);
        arr[size++] = data;
    }

    public void dequeue() { // o(n)
        if (!isEmpty()) {
            size--;
            if (size >= 0) {
                for (int i = 0; i < size; i++) {
                    arr[i] = arr[i+1];
                }
            }
        }
    }

    public int top() {
        if (size == 0) return -1;
        return arr[0];
    }

    public static void main(String[] args) {
        QueueArr s = new QueueArr(2);
        s.enqueue(1);
        s.enqueue(2);
        System.out.println("Stack: " + s.top());
        s.enqueue(3);
        System.out.println("Stack: " + s.top());

        s.dequeue();
        System.out.println("Stack: " + s.top());
        s.dequeue();
        System.out.println("Stack: " + s.top());
        s.dequeue();
        System.out.println("Stack: " + s.top());
        s.enqueue(4);
        System.out.println("Stack: " + s.top());
    }
}
