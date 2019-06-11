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
 * Created at 11.06.2019 18:25
 *
 * @author AMarchenkov
 * @since 11.06.2019
 */
public class OddEvenSortImplementation {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for (int v = 0; v < arr.length; v++) {
            arr[v] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            for (int j = i % 2; j < arr.length - 1; j = j + 2) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
