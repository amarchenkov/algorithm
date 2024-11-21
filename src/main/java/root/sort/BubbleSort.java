package root.sort;

import java.util.Arrays;

/**
 * Stable
 * Time: (Best - O(N), Average - O(N ^ 2), Worst - O(N ^ 2))
 * Space: O(1)
 */
public class BubbleSort {

	public static <T extends Comparable<T>> void sort(T[] input) {
		boolean hasSwapped = true;
		while (hasSwapped) {
			hasSwapped = false;
			for (int i = 0; i < input.length - 1; i++) {
				if (input[i].compareTo(input[i + 1]) > 0) {
					T tmp = input[i];
					input[i] = input[i + 1];
					input[i + 1] = tmp;
					hasSwapped = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{4, 6, 12, 6, 8, 3, 7, 9, 213, 5};

		System.out.println("Before:");
		System.out.println(Arrays.toString(arr));

		BubbleSort.sort(arr);

		System.out.println("After:");
		System.out.println(Arrays.toString(arr));
	}

}
