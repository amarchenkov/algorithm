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
        int[] arr = new int[]{4, 6, 12, 6, 8, 3, 7, 9, 213, 5};
        System.out.println(arr.length);

        for (int i = 0; i < arr.length - 1; i++) { //Количество проходов по массиву
            for (int j = 0; j < arr.length - 1 - i; j++) { //Проход по неотсортированным элементам
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        int c = 0;
        System.out.println(Arrays.toString(arr));
    }

}
