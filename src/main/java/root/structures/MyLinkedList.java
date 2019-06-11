package root.structures;

import java.util.HashSet;

/**
 * Created at 08.02.2019 10:32
 *
 * @author AMarchenkov
 * @since 08.02.2019
 */
public class MyLinkedList {

    private Node head;

    public boolean isEmpty() {
        return this.head == null;
    }

    public void insertAfter(Node node, int value) {
        Node tmpNext = node.getNext();
        node.next = new Node(value, tmpNext);
    }

    public void insert(int value) {
        final Node newNode = new Node(value, null);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.next = newNode;
        }
    }

    public Node search(int value) {
        if (isEmpty()) {
            return null;
        }
        Node current = this.head;
        while (current != null) {
            if (current.getValue() == value) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public Node get(int index) {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0) {
            return this.head;
        }
        Node current = this.head.getNext();
        int i = 1;
        while (current != null && i < index) {
            current = current.getNext();
            if (current == null) {
                throw new ArrayIndexOutOfBoundsException();
            }
            i++;
        }
        return current;
    }

    public int searchIndex(int value) {
        if (!isEmpty()) {
            Node current = this.head;
            int i = 0;
            while (current != null) {
                if (current.getValue() == value) {
                    return i;
                }
                current = current.getNext();
                i++;
            }
        }
        return -1;
    }

    public void delete(int value) {
        if (!isEmpty()) {
            Node current = this.head;
            Node prev = null;
            while (current != null) {
                if (current.getValue() == value) {
                    if (prev == null) {
                        this.head = current.getNext();
                    } else {
                        prev.next = current.getNext();
                    }
                }
                prev = current;
                current = current.getNext();
            }
        }
    }

    public static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "Node{value=" + value + '}';
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = this.head;
        while (current != null) {
            sb.append("{").append(current.getValue()).append("}");
            if (current.getNext() != null) {
                sb.append(" -> ");
            }

            current = current.getNext();
        }
        return sb.toString();
    }

    private void revere() {
        Node prev = head;
        Node current = head.next;
        head.next = null;
        while (current != null) {
            Node tmp = current.next;
            if (tmp == null) {
                head = current;
            }
            current.next = prev;
            prev = current;
            current = tmp;
        }
    }

    private void removeDuplicatesWithoutBuffer() {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    private void removeDuplicates() {
        if (head == null || head.next == null) {
            return;
        }
        HashSet<Integer> buffer = new HashSet<>();
        Node current = head.next;
        Node prev = head;
        while (current != null) {
            if (buffer.contains(current.value)) {
                prev.next = current.next;
            } else {
                buffer.add(current.value);
                prev = current;
            }
            current = current.next;
        }
    }

    private Node findElementFromEnd(int n) {
        return findElementFromEnd(head, n);
    }

    private Node findElementFromEnd(Node head, int n) {
        Node p1 = head;
        Node p2 = head;
        int i = 0;
        while (i < (n - 1)) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
            i++;
        }
        while (p1.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }

    private boolean hasLoop() {
        if (head == null) {
            return false;
        }

        Node slow, fast;
        slow = fast = head;

        while (true) {
            slow = slow.next;

            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }

            if (slow == null || fast == null) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insert(1);
        linkedList.insert(22);
        linkedList.insert(224);
        linkedList.insert(3);
        linkedList.insert(3);
        linkedList.insert(2);
        linkedList.insert(553);
        linkedList.insert(553);
        linkedList.insert(1000);
        linkedList.insertAfter(linkedList.get(2), 243123);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.search(553));
        System.out.println(linkedList.searchIndex(22));
        linkedList.delete(-1112);
        System.out.println(linkedList.toString());
        linkedList.revere();
        System.out.println("Reversed = " + linkedList.toString());
        linkedList.removeDuplicatesWithoutBuffer();
        System.out.println("Without duplicates = " + linkedList.toString());
        final Node elementFromEnd = linkedList.findElementFromEnd(3);
        System.out.println("3 from end = " + elementFromEnd);
    }

}
