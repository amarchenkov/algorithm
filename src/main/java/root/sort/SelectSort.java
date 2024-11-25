package root.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * <a href="https://habr.com/ru/articles/422085/">Link</a>
 * Not stable
 * Time: (Best - O(N ^ 2), Average - O(N ^ 2), Worst - O(N ^ 2))
 * Space: O(1)
 * Suppose we had a collection of elements where every element is an integer.
 * Selection sort will build up the sorted list by repeatedly finding the minimum element in that list and moving it to the front of the list through a swap.
 * It will proceed to swap elements appropriately until the entire list is sorted.
 */
public class SelectSort {

	public static <T extends Comparable<T>> void sort(T[] input) {
		for (int i = 0; i < input.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < input.length; j++) {
				if (input[j].compareTo(input[minIndex]) < 0) {
					minIndex = j;
				}
			}
			T tmp = input[i];
			input[i] = input[minIndex];
			input[minIndex] = tmp;
		}
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = new Random().nextInt(15);
		}
		System.out.println("Before:");
		System.out.println(Arrays.toString(arr));

		SelectSort.sort(arr);

		System.out.println("After:");
		System.out.println(Arrays.toString(arr));
	}
}
