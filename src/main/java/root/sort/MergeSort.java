package root.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = {1, 1314, 3, 45, 6, 6, 43, 2, 23, 5, 6, 78, 65, 4, 2, 12, 3, 4, 6, 8, 5, 2, 23};
		System.out.println("length = " + a.length);

		// 0..26
		mergeSort(a, 0, a.length - 1);
		System.out.println("Sorted - " + Arrays.toString(a));
	}

	private static void mergeSort(int[] a, int start, int finish) {
		System.out.println("Process range " + start + ".." + finish);
		if (finish <= start) {
			return;
		}
		int middle = (start + finish) / 2;
		mergeSort(a, start, middle);
		mergeSort(a, middle + 1, finish);
		merge(a, start, middle, finish);
	}

	private static void merge(int[] a, int start, int middle, int finish) {
		int leftLength = middle - start + 1;
		int rightLength = finish - middle;

		int[] leftArray = new int[leftLength];
		int[] rightArray = new int[rightLength];

		System.arraycopy(a, start, leftArray, 0, leftLength);
		for (int i = 0; i < rightLength; i++) {
			rightArray[i] = a[middle + i + 1];
		}

		int leftIndex = 0;
		int rightIndex = 0;

		for (int i = start; i < finish + 1; i++) {
			if (leftIndex < leftLength && rightIndex < rightLength) {
				if (leftArray[leftIndex] < rightArray[rightIndex]) {
					a[i] = leftArray[leftIndex];
					leftIndex++;
				} else {
					a[i] = rightArray[rightIndex];
					rightIndex++;
				}
			} else if (leftIndex < leftLength) {
				a[i] = leftArray[leftIndex];
				leftIndex++;
			} else if (rightIndex < rightLength) {
				a[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}


	}
}
