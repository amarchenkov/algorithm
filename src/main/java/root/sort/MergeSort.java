package root.sort;

import java.util.Arrays;

/**
 * Created at 19.04.2019 12:21
 *
 * @author AMarchenkov
 * @since 19.04.2019
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 4, 2, 1};
        System.out.println("length = " + a.length);

        // 0..26
        mergeSort(a, 0, a.length - 1);
        System.out.println("Sorted - " + Arrays.toString(a));
    }

    private static void mergeSort(int[] a, int start, int finish) {
        System.out.println("Process range " + start + ".." + finish);
        if (finish <= start) {
            System.out.println("Finish recursion");
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

        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = a[start + i];
        }
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
