package root.sort;

import java.util.Arrays;

/**
 * Created at 15.04.2019 12:38
 *
 * @author AMarchenkov
 * @since 15.04.2019
 */
public class OddEvenSort {
    public static void main(String[] args) {
        int[] a = {2, 4, 5, 6, 3, 4, 24, 576, 6, 5, 5, 4, 2, 345, 458, 6, 6, 534, 4, 234, 234};
        for (int i = 0; i < a.length; i++) {
            for (int j = (i % 2) == 1 ? 0 : 1; j < a.length - 1; j = j + 2) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
