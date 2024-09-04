package root.search;

public class InterpolationSearch {
	private static int deep = 0;

	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(interpolationSearch(5, array, 0, array.length - 1));
	}

	private static int interpolationSearch(int item, int[] array, int start, int end) {
		deep++;
		for (int i = 0; i < deep; i++) {
			System.out.print("*");
		}
		System.out.print("\n");
		int middle = start + ((item - array[start]) * (end - start) / (array[end] - array[start]));
		System.out.println("Middle = " + middle);
		if (array[middle] == item) {
			System.out.println("Found");
			return middle;
		}
		if (item < array[middle]) {
			System.out.println("Less");
			return interpolationSearch(item, array, start, middle - 1);
		}
		if (item > array[middle]) {
			System.out.println("More");
			return interpolationSearch(item, array, middle + 1, end);
		}
		return -1;
	}
}
