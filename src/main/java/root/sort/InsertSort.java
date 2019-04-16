/*
 * Copyright 2019 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
package root.sort;

import java.util.Arrays;

/**
 * Created at 28.03.2019 15:27
 *
 * @author AMarchenkov
 * @since 28.03.2019
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {2, 6, 9, 1, 64764, 23, 7, 12, 23, 57686, 0, 234, 32, 6, 68, 43, 2};

        for (int i = 1; i < a.length; i++) {
            int tmp = a[i]; //Передвигаемы элемент
            int j = i; //Начальный индекс для движения в обратную сторону
            while (j > 0 && a[j - 1] > tmp) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = tmp;
        }

        System.out.println(Arrays.toString(a));
    }

}
