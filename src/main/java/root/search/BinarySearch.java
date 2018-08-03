package root.search;

public class BinarySearch {

    private static int deep = 0;

    private static int binarySearch(int item, int[] array, int start, int end) {
        deep++;
        for (int i = 0; i < deep; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
        int middle = start + (end - start) / 2;
        System.out.println(start + " + (" + end + " - " + start + ") / 2");
        System.out.println("Middle = " + middle);
        if (array[middle] == item) {
            System.out.println("Found");
            return middle;
        }
        if (item < array[middle]) {
            System.out.println("Less");
            return binarySearch(item, array, start, middle - 1);
        }
        if (item > array[middle]) {
            System.out.println("More");
            return binarySearch(item, array, middle + 1, end);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 77, 88, 91, 123, 343, 666, 988};
        System.out.println(binarySearch(5, array, 0, array.length - 1));
    }

}
