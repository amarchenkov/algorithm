package root.sort;

import java.util.Arrays;

/**
 * Stable sort
 * Time - O(W * (N + K)), W - amount of digits, N - elements, K - amount of different values
 * Space - O(N + K)
 * 1. Find the number of digits in the maximum integer. Let that be W.
 * 2. For each integer, loop through digits from 1 to W in right to left order (least significant to most significant digit).
 * On each group of digits, perform counting sort.
 */
public class RadixSort {

	public static void main(String[] args) {
		int[] a = {1, 1314, 3, 45, 6, 6, 43, 2, 23, 5, 6, 78, 65, 4, 2, 12, 3, 4, 6, 8, 5, 2, 23};
		RadixSort.sort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void countingSort(int[] arr, int positionValue) {
		int[] counts = new int[10];
		for (int element : arr) {
			int current = element / positionValue;
			counts[current % 10] += 1;
		}

		int startingIndex = 0;
		for (int i = 0; i < 10; i++) {
			int count = counts[i];
			counts[i] = startingIndex;
			startingIndex += count;
		}

		int[] sorted = new int[arr.length];
		for (int element : arr) {
			int current = element / positionValue;
			sorted[counts[current % 10]] = element;
			counts[current % 10]++;
		}
		System.arraycopy(sorted, 0, arr, 0, arr.length);
	}

	public static void sort(int[] arr) {
		int maxElement = Arrays.stream(arr)
				.max()
				.orElse(Integer.MIN_VALUE);
		if (maxElement != Integer.MIN_VALUE) {
			int positionValue = 1;
			while (maxElement / positionValue != 0) {
				countingSort(arr, positionValue);
				positionValue *= 10;
			}
		}
	}

}