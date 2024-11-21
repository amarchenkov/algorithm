package root.sort;

import java.util.Arrays;

/**
 * Not stable
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] a = {2, 43, 7, 8, 4, 2, 5, 7, 9, 9};
		System.out.println("length = " + a.length);
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}

	private static void toHeap(int[] a, int length, int i) {
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;
		int largest = i;

		if (leftChild < length && a[leftChild] > a[largest]) {
			largest = leftChild;
		}

		if (rightChild < length && a[rightChild] > a[largest]) {
			largest = rightChild;
		}

		if (largest != i) {
			int tmp = a[i];
			a[i] = a[largest];
			a[largest] = tmp;
			toHeap(a, length, largest);
		}
	}

	private static void heapSort(int[] a) {
		if (a.length == 0) {
			return;
		}
		int length = a.length;

		for (int i = length / 2 - 1; i >= 0; i--) {
			System.out.println("Heap operation for " + i);
			toHeap(a, length, i);
		}

		for (int i = length - 1; i >= 0; i--) {
			int tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;

			toHeap(a, i, 0);
		}
	}
}
