package root.sort;

import java.util.Arrays;

/**
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {3, 44, 67, 8, 8, 6, 4, 21, 23, 4, 1, 6, 7, 789, 678, 4, 3, 123, 1, 21};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int left, int right) {
        if (right <= left) {
            return;
        }
        int pivot = partition(a, left, right);
        quickSort(a, left, pivot - 1);
        quickSort(a, pivot + 1, right);
    }

    private static int partition(int[] a, int left, int right) {
        int leftPtr = left;
        int rightPtr = right;
        int pivot = a[right];

        while (true) {
            while (a[leftPtr] < pivot) {
                leftPtr++;
            }
            while (rightPtr > 0 && a[rightPtr] >= pivot) {
                rightPtr--;
            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                int tmp = a[leftPtr];
                a[leftPtr] = a[rightPtr];
                a[rightPtr] = tmp;
            }
        }
        int tmp = a[leftPtr];
        a[leftPtr] = a[right];
        a[right] = tmp;
        return leftPtr;
    }
}
