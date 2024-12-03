package root.sort;

import java.util.*;

/**
 * Stable
 * Time: (Worst - O(N ^ 2), Average - O(N + K))
 * Space: O(N + K)
 * 1. Create an initial array of K empty buckets.
 * 2. Distribute each element of the array into its respective bucket. A common way to map values to buckets is via the following function:
 * floor(K * A[i] / max(A))
 * 3. Sort each bucket using insertion sort or some other sorting algorithm.
 * 4. Concatenate the sorted buckets in order to create the sorted list.
 */
public class BucketSort {

	public static void main(String[] args) {
		int[] a = {1, 1314, 3, 45, 6, 6, 43, 2, 23, 5, 6, 78, 65, 4, 2, 12, 3, 4, 6, 8, 5, 2, 23};
		BucketSort.sort(a, 5);
		System.out.println(Arrays.toString(a));
	}

	public static void sort(int[] input, int bucketCount) {
		List<List<Integer>> buckets = new ArrayList<>(bucketCount);
		for (int i = 0; i < bucketCount; i++) {
			buckets.add(new ArrayList<>());
		}
		int shift = Arrays.stream(input).min().getAsInt();
		int max = Arrays.stream(input).max().getAsInt() - shift;

		double bucketSize = (double) max / bucketCount;
		if (bucketSize < 1) {
			bucketSize = 1.0;
		}

		for (int element : input) {
			// same as K * arr[i] / max(lst)
			int index = (int) ((element - shift) / bucketSize);
			if (index == bucketCount) {
				buckets.get(bucketCount - 1).add(element);
			} else {
				buckets.get(index).add(element);
			}
		}

		for (List<Integer> bucket : buckets) {
			Collections.sort(bucket);
		}
		List<Integer> sortedList = new ArrayList<>();
		for (List<Integer> bucket : buckets) {
			sortedList.addAll(bucket);
		}

		for (int i = 0; i < input.length; i++) {
			input[i] = sortedList.get(i);
		}
	}

}
