package root;

import java.util.Arrays;
import java.util.Random;

/**
 * Created at 01.04.2020 15:54
 *
 * @author a_marchenkov
 * @since 01.04.2020
 */
public class InputDataUtils {
    public static int[] genRandomArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        int[] arr = new int[size];
        Random random = new Random();
        for (int v = 0; v < arr.length; v++) {
            arr[v] = random.nextInt(50);
        }
        return arr;
    }
}
