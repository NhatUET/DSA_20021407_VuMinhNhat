package week4;

import java.io.BufferedWriter;
import java.io.IOException;

public class insertLastNode {
        static class SinglyLinkedListNode {
            public int data;
            public SinglyLinkedListNode next;

            public SinglyLinkedListNode(int nodeData) {
                this.data = nodeData;
                this.next = null;
            }
        }

        static class SinglyLinkedList {
            public SinglyLinkedListNode head;

            public SinglyLinkedList() {
                this.head = null;
            }
        }

        public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
            while (node != null) {
                bufferedWriter.write(String.valueOf(node.data));

                node = node.next;

                if (node != null) {
                    bufferedWriter.write(sep);
                }
            }
        }

        /*
         * For your reference:
         *
         * SinglyLinkedListNode {
         *     int data;
         *     SinglyLinkedListNode next;
         * }
         *
         */
        static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            newNode.data = data;
            newNode.next = null;
            if(head == null) head = newNode;
            else
            {
                SinglyLinkedListNode node;
                node = head;
                while(node.next != null)
                    node = node.next;
                node.next = newNode;
            }
            return head;

        }
}
