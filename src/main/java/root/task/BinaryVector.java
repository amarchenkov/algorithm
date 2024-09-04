package root.task;

public class BinaryVector {
	public static void main(String[] args) {
		int[] a1 = {0, 1, 1, 1, 1, 0}; //4
		int[] a2 = {0, 1, 1, 1, 1, 1}; //5
		int[] a3 = {1, 1, 1, 1, 1, 0}; //5
		int[] a4 = {1, 1, 1}; //3
		int[] a5 = {0, 0}; //0
		int[] a6 = {}; //0
		System.out.println(findMaxLen(a1) == 4);
		System.out.println(findMaxLen(a2) == 5);
		System.out.println(findMaxLen(a3) == 5);
		System.out.println(findMaxLen(a4) == 3);
		System.out.println(findMaxLen(a5) == 0);
		System.out.println(findMaxLen(a6) == 0);
	}

	private static int findMaxLen(int[] arr) {
		int best = 0;
		int current = 0;
		for (int i : arr) {
			if (i > 0) {
				current++;
				best = Math.max(current, best);
			} else {
				current = 0;
			}
		}
		return best;
	}
}
