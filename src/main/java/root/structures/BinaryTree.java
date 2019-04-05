package root.structures;

import java.util.Random;

/**
 * Created at 20.02.2019 15:49
 *
 * @author AMarchenkov
 * @since 20.02.2019
 */
public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
            return;
        }
        Node<T> current = root;
        while (current != null) {

        }
    }

    public Node<T> search(T data) {
        if (root == null) {
            return null;
        }
        Node<T> current = root;
        while (current != null) {
            if (current.getData().compareTo(data) == 0) {
                return current;
            }
            if (data.compareTo(current.getData()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    public void delete(T data) {

    }

    public static void main(String[] args) {
        String a = new Random().nextInt(100) + "b";
        System.out.println(a);
    }

}

class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public void visitNode() {}


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
