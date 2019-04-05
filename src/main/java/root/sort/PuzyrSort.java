package root.sort;

import java.util.Random;

public class PuzyrSort {

    /**
     * N - 1 проходов - внешний цикл
     * Внутренний цикл - N - 1 - [Номер прохода]
     */
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Random().nextInt(15);
        }

        int k = 0;
        for (int i = 0; i < 10 - 2; i++) {
            for (int j = 0; j < 10 - 1 - i; j++) {
                k++;
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(k);

        k = 0;
        for (int o = 10 - 1; o > 1; o--) {
            for (int j = 0; j < o; j++) {
                k++;
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(k);

        System.out.println("Bye");
    }
}
