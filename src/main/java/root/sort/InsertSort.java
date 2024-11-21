package root.sort;

import java.util.Arrays;

/**
 * Stable
 * <a href="https://habr.com/ru/articles/415935/">Link</a>
 * Time: (Best - O(N), Average - O(N ^ 2), Worst - O(N ^ 2))
 * Space: O(1)
 * Given a collection of integers, you can sort the list by proceeding from the start of the list,
 * and every time you encounter an element that is out of order, you can continuously swap places with previous elements
 * until it is inserted in its correct relative location based on what you’ve processed thus far.
 * This process is best understood with a visual example
 */
public class InsertSort {

	public static <T extends Comparable<T>> void sort(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int currentIndex = i;
			while (currentIndex > 0 && arr[currentIndex - 1].compareTo(arr[currentIndex]) > 0) {
				T temp = arr[currentIndex];
				arr[currentIndex] = arr[currentIndex - 1];
				arr[currentIndex - 1] = temp;
				currentIndex -= 1;
			}
		}
	}

	public static void main(String[] args) {
		Integer[] a = {2, 6, 9, 1, 64764, 23, 7, 12, 23, 57686, 0, 234, 32, 6, 68, 43, 2};
		InsertSort.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
