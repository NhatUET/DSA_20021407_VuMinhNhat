package week4;

import java.io.BufferedWriter;
import java.io.IOException;

public class insertNodeIntoSortLlist {
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    class DoublyLinkedListPrintHelper {
        public static void printList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
            while (node != null) {
                bufferedWriter.write(String.valueOf(node.data));

                node = node.next;

                if (node != null) {
                    bufferedWriter.write(sep);
                }
            }
        }
    }

    class Result {

        /*
         * Complete the 'sortedInsert' function below.
         *
         * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
         * The function accepts following parameters:
         *  1. INTEGER_DOUBLY_LINKED_LIST llist
         *  2. INTEGER data
         */

        /*
         * For your reference:
         *
         * DoublyLinkedListNode {
         *     int data;
         *     DoublyLinkedListNode next;
         *     DoublyLinkedListNode prev;
         * }
         *
         */

        public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
            // Write your code here
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
            newNode.data = data;

            if (head == null) return newNode;
            else {
                DoublyLinkedListNode p1 = null;
                DoublyLinkedListNode p2 = head;

                while (p2 != null && p2.data < data) {
                    p1 = p2;
                    p2 = p2.next;
                }
                if (p2 == null) {
                    p1.next = newNode;
                    newNode.prev = p1;
                } else if (data < head.data) {
                    head.prev = newNode;
                    newNode.next = head;
                    return newNode;
                } else {
                    p1.next = newNode;
                    p2.prev = newNode;
                    newNode.prev = p1;
                    newNode.next = p2;
                }
            }
            return head;
        }

    }
}
