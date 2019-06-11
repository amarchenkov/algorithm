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
 * Created at 10.06.2019 19:01
 *
 * @author AMarchenkov
 * @since 10.06.2019
 */
public class InsertSortImplementation {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for (int v = 0; v < arr.length; v++) {
            arr[v] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
