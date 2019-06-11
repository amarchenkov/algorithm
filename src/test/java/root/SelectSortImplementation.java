package root;

import java.util.Arrays;
import java.util.Random;

/**
 * Created at 10.06.2019 18:54
 *
 * @author AMarchenkov
 * @since 10.06.2019
 */
public class SelectSortImplementation {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for (int v = 0; v < arr.length; v++) {
            arr[v] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
