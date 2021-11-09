package week9;

public class BinTree<K> {
    private final K k;
    private BinTree<K> left, right;

    public BinTree(K k) {
        this.k = k;
    }

    public BinTree(K k, BinTree<K> left, BinTree<K> right) {
        this.k = k;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return k.toString();
    }

    private void traversePostOrder() {
        if (left != null) left.traversePreOrder();
        if (right != null) right.traversePreOrder();
        System.err.print(this + " ");
    }

    private void traverseInOrder() {
        if (left != null) left.traversePreOrder();
        System.err.print(this + " ");
        if (right != null) right.traversePreOrder();
    }

    private void traversePreOrder() {
        System.err.print(this + " ");
        if (left != null) left.traversePreOrder();
        if (right != null) right.traversePreOrder();
    }

    public int count() {
        int leftCount = left == null ? 0 : left.count();
        int rightCount = right == null ? 0 : right.count();
        return 1 + leftCount + rightCount;
    }

    public int height() {
        int leftHeight = left == null ? -1 : left.height();
        int rightHeight = right == null ? -1 : right.height();
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public static void main(String[] args) {
        BinTree<String> d = new BinTree<>("D");
        BinTree<String> e = new BinTree<>("E");
        BinTree<String> f = new BinTree<>("F");
        BinTree<String> g = new BinTree<>("G");
        BinTree<String> b = new BinTree<>("B", d, e);
        BinTree<String> c = new BinTree<>("C", f, g);
        BinTree<String> a = new BinTree<>("A", b, c);
//        a.traversePreOrder();
//        a.traverseInOrder();
//        a.traversePostOrder();
//        System.err.println(c.count());
        System.err.println(a.count());
        System.err.println(b.count());
        System.err.println(e.count());
    }
}
