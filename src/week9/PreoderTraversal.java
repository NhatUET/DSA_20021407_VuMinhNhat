package week9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PreoderTraversal {
    static class Node {
        InorderTraversal.Node left;
        InorderTraversal.Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    class Solution {
        public static void preOrder(InorderTraversal.Node root) {
            if (root != null) {
                System.out.print(root.data + " ");
                preOrder(root.left);
                preOrder(root.right);
            }
        }

        public static InorderTraversal.Node insert(InorderTraversal.Node root, int data) {
            if(root == null) {
                return new InorderTraversal.Node(data);
            } else {
                InorderTraversal.Node cur;
                if(data <= root.data) {
                    cur = insert(root.left, data);
                    root.left = cur;
                } else {
                    cur = insert(root.right, data);
                    root.right = cur;
                }
                return root;
            }
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            InorderTraversal.Node root = null;
            while(t-- > 0) {
                int data = scan.nextInt();
                root = insert(root, data);
            }
            scan.close();
            preOrder(root);
        }
    }
}
