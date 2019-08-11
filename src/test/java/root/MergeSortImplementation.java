/*
 * Copyright 2019 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
package root;

import java.util.Arrays;
import java.util.Random;

/**
 * Created at 13.06.2019 13:14
 *
 * @author AMarchenkov
 * @since 13.06.2019
 */
public class MergeSortImplementation {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int v = 0; v < arr.length; v++) {
            arr[v] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int finish) {
        if (finish <= start) {
            return;
        }
        int middle = (start + finish) / 2;
        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, finish);
        merge(arr, start, middle, finish);
    }

    private static void merge(int[] arr, int start, int middle, int finish) {
        int leftLength = middle - start + 1;
        int rightLength = finish - middle;
        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];
        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = arr[start + i];
        }
        for (int i = 0; i < rightLength; i++) {
            rightArray[i] = arr[middle + 1 + i];
        }
        int leftPosition = 0;
        int rightPosition = 0;
        for (int i = start; i <= finish; i++) {
            if (leftPosition < leftLength && rightPosition < rightLength) {
                if (leftArray[leftPosition] < rightArray[rightPosition]) {
                    arr[i] = leftArray[leftPosition];
                    leftPosition++;
                } else {
                    arr[i] = rightArray[rightPosition];
                    rightPosition++;
                }
            } else if (leftPosition < leftLength) {
                arr[i] = leftArray[leftPosition];
                leftPosition++;
            } else if (rightPosition < rightLength) {
                arr[i] = rightArray[rightPosition];
                rightPosition++;
            }
        }
    }


}
