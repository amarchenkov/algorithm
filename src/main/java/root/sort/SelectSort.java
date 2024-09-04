package root.sort;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Random().nextInt(15);
        }
        System.out.println("Before:");
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { //Поиск минимального начиная от i-го элемента
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            //Меняем местами i-й элемент
            int tmp = arr[i];
            arr[i] = min;
            arr[minIndex] = tmp;
        }

        System.out.println("After:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Bye");
    }
}
