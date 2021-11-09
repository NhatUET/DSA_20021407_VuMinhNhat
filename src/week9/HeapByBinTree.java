package week9;

import java.util.LinkedList;
import java.util.Queue;

public class HeapByBinTree {
    Node root;

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    // add
    private static Node add(Node cur, int val) {
        if (cur == null) {
            return new Node(val);
        }

        if (cur.val < val) {
            cur.left = add(cur.left, val);
        } else if (cur.val > val) {
            cur.right = add(cur.right, val);
        } else {
            return cur;
        }
        return cur;
    }

    public void addNode(int value) {
        root = add(root, value);
    }

    //find
    private boolean contain(Node cur, int val) {
        if (cur == null) return false;
        if (val == cur.val) return true;
        return val < cur.val ? contain(cur.left, val) : contain(cur.right, val);
    }

    public boolean containNode(int val) {
        return contain(root, val);
    }

    //del

    public Node delete(Node cur, int val) {
        if (cur == null) return cur;
        if (val == cur.val) {
            if (cur.left == null && cur.right == null) return null;
            if (cur.left == null) return cur.right;
            if (cur.right == null) return cur.left;
        }
        if (val < cur.val) cur.left = delete(cur.left, val);
        else cur.right = delete(cur.right, val);
        return cur;
    }

    public void delNode(int val) {
        root = delete(root, val);
    }

    // traverse in order - DFS
    public void traverseInOrder(Node root) {
        if (root == null) return;
        if (root.left != null) traverseInOrder(root.left);
        System.out.print(root.val + " ");
        if (root.right != null) traverseInOrder(root.right);
    }
    //pre
    public void traversePreOrder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        if (root.left != null) traversePreOrder(root.left);
        if (root.right != null) traversePreOrder(root.right);
    }
    // traverse level Order - BFS
    public void traverseLevelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
    }
    public static void main(String[] args) {
        HeapByBinTree h1 = new HeapByBinTree();
        int[] a = {1,2,3,4,5,6,7,8};
        for (int j : a) {
            h1.addNode(j);
        }
        h1.traversePreOrder(h1.root);
    }
}
