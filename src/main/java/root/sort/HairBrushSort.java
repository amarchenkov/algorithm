package root.sort;

import java.util.Arrays;

/**
 * Created at 15.04.2019 12:48
 *
 * @author AMarchenkov
 * @since 15.04.2019
 */
public class HairBrushSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 7, 8, 5, 3, 3, 2, 46, 7, 8, 7, 7845, 5, 3, 3, 4, 346, 576, 4, 4, 3, 57, 7568, 56};
        int step = a.length - 1;
        while (step >= 1) {
            for (int j = 0; j + step < a.length; j++) {
                if (a[j] > a[j + step]) {
                    int tmp = a[j];
                    a[j] = a[j + step];
                    a[j + step] = tmp;
                }
            }
            step = (int) (step / 1.247);
        }
        System.out.println(Arrays.toString(a));
    }
}
