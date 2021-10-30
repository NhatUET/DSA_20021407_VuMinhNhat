package week8;

public class binaryHeap {
    private int[] p;
    private int size = 0;

    public binaryHeap(int capacity){
        p = new int[capacity + 1];
    }

    public binaryHeap(int[] a) {
        p = new int[a.length + 1];
        this.p = a;
        this.size = a.length;
    }
    public boolean less(int i, int j) {
        return p[i] < p[j];
    }

    public void exch(int i, int j) {
        int tmp = p[i];
            p[i] = p[j];
            p[j] = tmp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * đẩy phần tử lớn hơn lên trên.
     * @param k là index của phần tử cần swim
     */
    public void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    /**
     * thêm phần tử bào heap.
     * sau đó đẩy dần lên trên nếu nó lớn hơn.
     * @param val giá trị cần thêm vào
     */
    public void insert(int val) {
        p[++size] = val;
        swim(size);
    }

    /**
     * đẩy phần tử nhỏ hơn xuống dưới.
     * Complexity: O(N).
     * @param i vị trí cần sink
     */
    public void sink(int i) {
        while (2 * i <= size) {
            int j = 2 * i;
            if (j < size && less(j, j + 1)) j++;
            if (!less(i, j)) break;
            exch(i, j);
            i = j;
        }
    }

    /**
     * Xóa phần tử lớn nhất của heap.
     * Bằng cách lấy giá trị của p[1] gán vào max sau đó đổi p[1] với p[n], size - 1.
     * Đẩy i = 1 xuống đúng vị trí.
     * gán p[size+1] = null.
     * @return giá trị lớn nhất đó
     */
    public int delMax() {
        int max = p[1];
        exch(1,size--);
        sink(1);
        //p[size+1] = 0;
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9,8,6,4,2};
        binaryHeap h1 = new binaryHeap(1000);
    }
}
