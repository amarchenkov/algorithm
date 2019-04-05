package root.sort;

import java.util.Arrays;

/**
 * Created at 27.03.2019 16:45
 *
 * @author AMarchenkov
 * @since 27.03.2019
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 12, 55, 3, 5, 777, 12, 532, 231, 23, 65, 856, 345};
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
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
