package root;

import java.util.LinkedList;
import java.util.ListIterator;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(33);
        head.next.next = new Node(13);
        head.next.next.next = new Node(123);
        head.next.next.next.next = new Node(553);
        head.next.next.next.next.next = new Node(666);

        listToString(head);

        Node nHead = reverse(head);

        listToString(nHead);
    }

    private static Node reverse(Node head) {
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private static void listToString(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

    }
}
