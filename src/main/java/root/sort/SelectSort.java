package root.sort;

import java.util.Random;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Random().nextInt(15);
        }

        for (int i = 0; i < 10 - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < 10; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = min;
            arr[minIndex] = tmp;

        }
        System.out.println("Bye");
    }
}
