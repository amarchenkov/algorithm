package root.structures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation if a binary tree with arbitrary value of a node
 * TODO: implement delete node
 */
public class BinaryTree<T extends Comparable<T>> {

	private Node<T> root;

	private final Queue<Node<T>> q = new LinkedList<>();

	private void depth() {
		if (root == null) {
			return;
		}
		depth(root);
	}

	private void depth(Node<T> node) {
		if (node.getLeft() != null) {
			depth(node.getLeft());
		}
		node.visitNode();
		if (node.getRight() != null) {
			depth(node.getRight());
		}
	}

	private void breadth() {
		if (root == null) {
			return;
		}
		q.offer(root);
		while (!q.isEmpty()) {
			Node<T> poll = q.poll();
			poll.visitNode();
			if (poll.getLeft() != null) {
				q.offer(poll.getLeft());
			}
			if (poll.getRight() != null) {
				q.offer(poll.getRight());
			}
		}

	}

	private void insert(T data) {
		Node<T> newNode = new Node<>(data);
		if (root == null) {
			this.root = newNode;
			return;
		}
		Node<T> current = root;
		Node<T> parent;
		while (true) {
			parent = current;
			if (newNode.getData().compareTo(current.getData()) < 0) {
				current = current.getLeft();
				if (current == null) {
					parent.setLeft(newNode);
					return;
				}
			} else {
				current = current.getRight();
				if (current == null) {
					parent.setRight(newNode);
					return;
				}
			}
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
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(235);
		tree.insert(3);
		tree.insert(8);
		tree.insert(2);
		tree.insert(32);
		tree.insert(5);
		tree.insert(775);
		tree.insert(23);
		tree.insert(365);
		tree.depth();
		System.out.println("-----------------");
		tree.breadth();
	}

	public static class Node<T> {

		private T data;

		private Node<T> left;

		private Node<T> right;

		Node(T data) {
			this.data = data;
		}

		public void visitNode() {
			System.out.println("Node visited {" + data + "}");
		}

		T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}
	}

}
