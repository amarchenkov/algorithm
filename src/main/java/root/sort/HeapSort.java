package root.sort;

import java.util.Arrays;

/**
 * Not stable
 * Time: (Best - O(N LogN), Average - O(N LogN), Worst - O(N LogN))
 * Space: O(1)
 * 1. Convert array to a Max-Heap
 * 1.1 Start from the end of the array. (length / 2 - 1) - index of the last node with the children
 * 1.2 There are two cases for a node
 * 		-It is greater than its left child and right child (if any).
 * 			In this case, proceed to next node (one index before current array index)
 * 		- There exists a child node that is greater than the current node
 * 			In this case, swap the current node with the child node. This fixes a violation of the max-heap property
 * 			Repeat the process with the node until the max-heap property is no longer violated
 * 1.3 Repeat step 2 on every node in the binary tree from bottom-up.
 * 2. Sort list
 * 2.1 Take the maximum element at index 0 (we know this is the maximum element because of the max-heap property) and swap it with the last element in the array (this element's proper place).
 * 2.2 We now have sorted an element (the last element). We can now ignore this element and decrease heap size by 1, thereby omitting the max element from the heap while keeping it in the array.
 * 2.3 Treat the remaining elements as a new heap. There are two cases:
 * 		-The root element violates the max-heap property
 * 			Sink this node into the heap until it no longer violates the max-heap property. Here the concept of "sinking" a node refers to swapping the node with one of its children until the heap property is no longer violated.
 * 		- The root element does not violate the max-heap property
 * 			Proceed to step (4)
 * 2.4 Repeat step 1 on the remaining unsorted elements. Continue until all elements are sorted.
 */
public class HeapSort {

	public static <T extends Comparable<T>> void sort(T[] input) {
		for (int i = input.length / 2 - 1; i >= 0; i--) {
			toMaxHeap(input, input.length, i);
		}

		for (int i = input.length - 1; i >= 0; i--) {
			T tmp = input[i];
			input[i] = input[0];
			input[0] = tmp;
			toMaxHeap(input, i, 0);
		}
	}

	private static <T extends Comparable<T>> void toMaxHeap(T[] input, int length, int currentElementIdx) {
		int leftChild = 2 * currentElementIdx + 1;
		int rightChild = 2 * currentElementIdx + 2;
		int largest = currentElementIdx;

		if (leftChild < length && input[leftChild].compareTo(input[largest]) > 0) {
			largest = leftChild;
		}

		if (rightChild < length && input[rightChild].compareTo(input[largest]) > 0) {
			largest = rightChild;
		}

		if (largest != currentElementIdx) {
			T tmp = input[currentElementIdx];
			input[currentElementIdx] = input[largest];
			input[largest] = tmp;
			toMaxHeap(input, length, largest);
		}
	}

	public static void main(String[] args) {
		Integer[] a = {2, 43, 7, 8, 4, 2, 5, 7, 9, 9};
		System.out.println("length = " + a.length);
		HeapSort.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
