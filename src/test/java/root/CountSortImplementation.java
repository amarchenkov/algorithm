package root;

import java.util.Arrays;
import java.util.Random;

/**
 * Created at 10.06.2019 17:07
 *
 * @author AMarchenkov
 * @since 10.06.2019
 */
public class CountSortImplementation {
    public static void main(String[] args) {
        int[] values = new int[10];
        int[] arr = new int[20];
        Random random = new Random();
        for (int v = 0; v < arr.length; v++) {
            arr[v] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(arr));
        for (int value : arr) {
            values[value]++;
        }
        System.out.println(Arrays.toString(values));

        for (int j = 0; j < values.length; j++) {
            for (int k = 0; k < values[j]; k++) {
                System.out.print(j + ", ");
            }
        }

    }
}
