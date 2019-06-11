package root.sort;

import java.util.Arrays;

/**
 * Created at 15.04.2019 12:03
 *
 * @author AMarchenkov
 * @since 15.04.2019
 */
public class ShakerSort {
    public static void main(String[] args) {
        int[] a = {92, 4, 3, 3, 67, 1, 7, 0, 6, 5, 42, 1, 4, 44, 6, 43, 5, 7, 4, 43, 243, 6, 0, 7, 5};
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                }
            }
            right--;
            for (int j = right; j > left; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
            left++;
        }
//        int minSorted = 0;
//        int maxSorted = a.length - 1;
//        while (minSorted < maxSorted) {
//            for (int i = minSorted; i < maxSorted; i++) {
//                if (a[i] > a[i + 1]) {
//                    int tmp = a[i];
//                    a[i] = a[i + 1];
//                    a[i + 1] = tmp;
//                }
//            }
//            maxSorted--;
//            for (int j = maxSorted; j > minSorted; j--) {
//                if (a[j] < a[j - 1]) {
//                    int tmp = a[j];
//                    a[j] = a[j - 1];
//                    a[j - 1] = tmp;
//                }
//            }
//            minSorted++;
//        }
        System.out.println(Arrays.toString(a));
    }
}
