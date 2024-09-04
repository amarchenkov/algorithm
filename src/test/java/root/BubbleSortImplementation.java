package root;

import java.util.Arrays;
import java.util.Random;

/**
 * Created at 10.06.2019 16:58
 *
 * @author AMarchenkov
 * @since 10.06.2019
 */
public class BubbleSortImplementation {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for (int v = 0; v < arr.length; v++) {
            arr[v] = random.nextInt(50);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
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
