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
 * Created at 13.06.2019 13:44
 *
 * @author AMarchenkov
 * @since 13.06.2019
 */
public class HairBrushSortImplementation {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int v = 0; v < arr.length; v++) {
            arr[v] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(arr));

        int step = arr.length - 1;
        while (step >= 1) {
            for (int i = 0; i + step < arr.length; i++) {
                if (arr[i] > arr[i + step]) {
                    int tmp = arr[i + step];
                    arr[i + step] = arr[i];
                    arr[i] = tmp;
                }
            }
            step = (int) (step / 1.247);
        }
        System.out.println(Arrays.toString(arr));
    }
}
