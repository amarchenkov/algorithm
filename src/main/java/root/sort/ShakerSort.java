package root.sort;

/**
 * Created at 15.04.2019 12:03
 *
 * @author AMarchenkov
 * @since 15.04.2019
 */
public class ShakerSort {

    public static void sort(int[] unsortedArray) {
        int left = 0;
        int right = unsortedArray.length - 1;

        while (left < right) {
            for (int i = left; i < right; i++) {
                if (unsortedArray[i] > unsortedArray[i + 1]) {
                    int tmp = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[i + 1];
                    unsortedArray[i + 1] = tmp;
                }
            }
            right--;
            for (int j = right; j > left; j--) {
                if (unsortedArray[j] < unsortedArray[j - 1]) {
                    int tmp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j - 1];
                    unsortedArray[j - 1] = tmp;
                }
            }
            left++;
        }
    }

}
