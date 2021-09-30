package week4;

import java.io.BufferedWriter;
import java.io.IOException;

public class reverseDoubleLList {
    class DoublyLinkedListNode {
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
         * Complete the 'reverse' function below.
         *
         * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
         * The function accepts INTEGER_DOUBLY_LINKED_LIST llist as parameter.
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

        public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
            // Write your code here
            if(head == null) return null;
            if(head.next == null)
            {
                head.next = head.prev;
                head.prev = null;
                return head;
            }
            else
            {
                DoublyLinkedListNode prev_node = head.prev;
                DoublyLinkedListNode next_node = head.next;

                head.next = prev_node;
                head.prev = next_node;

                return reverse(next_node);
            }
        }

    }
}
