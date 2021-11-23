package week10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    public Tree(int data) {
        root = new Node(data, null, null);
    }

    static class Node {
        int data;
        boolean visited;
        Node parent;
        List<Node> children;

        public Node(int data, Node parent, List<Node> children) {
            this.data = data;
            this.parent = parent;
            this.children = children;
            this.visited = false;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + '}';
        }
    }

    public static Node find(Node root, int parent) {
        if (root.data == parent) return root;
        if (root.children == null) return null;
        for (Node x : root.children) {
            x.visited = true;
            Node cur = find(x, parent);
            if (cur != null) return cur;
        }
        return null;
    }
    static void insertNode(Node root, int parent, int newInt) {
        if (root != null) {
            Node nodePr = find(root, parent);
            if (nodePr != null) {
                if (nodePr.children == null) nodePr.children = new ArrayList<Node>();
                nodePr.children.add(new Node(newInt, nodePr, null));
            }
        } else {
            root = new Node(newInt, null, null);
        }
    }

    static void delete(Node root, int key) {
        if (root == null) return;
        Node child = find(root, key);
        if (child != null) {
            child.children.remove(key);
        }
    }

    static boolean isBinaryTree(Node root) {
        if (root == null || root.children == null || root.children.size() == 2) return true;
        for (Node x : root.children) {
            if (!isBinaryTree(x)) return false;
        }
        return true;
    }

    static boolean isBinarySearchTree(Node root) {
        if (isBinaryTree(root)) {
            if (root.children.get(0).data < root.data && root.children.get(1).data > root.data) return true;
            for (Node x : root.children) {
                return isBinarySearchTree(x);
            }
        }
        return false;
    }

    static int height(Node root) {
        if (root == null) return -1;
        if (root.children == null) return 0;
        int heightTree = -1;
        for (Node x : root.children) {
            heightTree = Math.max(heightTree, height(x));
        }
        return 1 + heightTree;
    }

    static void print(Node root) {
        // In cây theo từng tầng một
        if (root == null) return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.toString() + " ");
            if (cur.children != null) {
                for (Node x : cur.children) {
                    q.add(x);
                }
            }
        }
        System.out.println();
    }

    static public void preorder(Node root) {
        if (root != null) {
            if (root.children != null) {
                for (Node x : root.children) preorder(x);
            }
            System.out.print(root.toString() + " ");
        }
    }

    static public void postorder(Node root) {
        if (root != null) {
            if (root.children != null) {
                for (int i = root.children.size() - 1; i >= 0; i--) {
                    postorder(root.children.get(i));
                }
            }
            System.out.print(root.toString() + " ");
        }
    }

    public static void main(String[] args) {
/*
                        5                   -> isBST height = 2;
                    3       7
                  1   4   6    8
        */

        // Tree generalTree = new Tree();
        // generalTree.root = new Node(5, null, null);

        Tree generalTree = new Tree(5); // root = Node{data=5}
        insertNode(generalTree.root, 5, 3);
        insertNode(generalTree.root, 5, 7);
        insertNode(generalTree.root, 3, 1);
        insertNode(generalTree.root, 3, 4);
        insertNode(generalTree.root, 7, 6);
        insertNode(generalTree.root, 7, 8);

        // delete(generalTree.root, 4);

        System.out.println(isBinarySearchTree(generalTree.root));

        System.out.println(height(generalTree.root));

        System.out.println("LevelOrder Traversal:");
        print(generalTree.root);

        System.out.println('\n' + "Preorder Traversal:");
        preorder(generalTree.root);

        System.out.println("\n\n" + "Postorder:");
        postorder(generalTree.root);
        delete(generalTree.root, 7);
        System.out.println("LevelOrder Traversal:");
    }

    /* b2
    public static int height(Node root) {
      	int lH = root.left == null ? -1 : height(root.left);
        int rH = root.right == null ? -1 : height(root.right);
        return 1 + Math.max(lH,rH);
    }
     */

    /* b5
        boolean check(Node x, int min, int max) {
            if (x == null) return true;
            if (x.data <= min || x.data >= max) return false;
            if (x.left == null && x.right == null) return true;
            return check(x.left, min, x.data) && check(x.right, x.data, max);
        }
        boolean checkBST(Node root) {
            return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
     */
    /* b6
        static Node insert(Node root,int val) {
           if(root == null) {
               root = new Node();
               root.val = val;
               root.ht = setHeight(root);
               return root;
           }
           if(val <= root.val) {
               root.left = insert(root.left, val);
           }
           else if (val > root.val) {
               root.right = insert(root.right, val);
           }
           int balance = height(root.left) - height(root.right);

           if(balance > 1) {
               if(height(root.left.left) >= height(root.left.right)) {
                   root = rightRotation(root);
               }
               else {
                   root.left = leftRotation(root.left);
                   root = rightRotation(root);
               }
           }
           else if(balance < -1) {
               if(height(root.right.right) >= height(root.right.left)) {
                   root = leftRotation(root);
               }
               else {
                   root.right = rightRotation(root.right);
                   root = leftRotation(root);
               }
           }
           else {
               root.ht = setHeight(root);
           }
           return root;
       }

       private static Node rightRotation(Node root) {
           Node newRoot = root.left;
           root.left = newRoot.right;
           newRoot.right = root;
           root.ht = setHeight(root);
           newRoot.ht = setHeight(newRoot);
           return newRoot;
       }

       private static Node leftRotation(Node root) {
           Node newRoot = root.right;
           root.right = newRoot.left;
           newRoot.left = root;
           root.ht = setHeight(root);
           newRoot.ht = setHeight(newRoot);
           return newRoot;
       }

       private static int height(Node root) {
           if(root == null)
               return -1;
           else
               return root.ht;
       }

       private static int setHeight(Node root) {
           if(root == null) {
               return -1;
           }
           else {
               return 1 + Math.max(height(root.left), height(root.right));
           }
       }
     */
}