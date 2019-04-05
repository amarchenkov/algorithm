package root.sort;

/**
 * Created at 28.03.2019 15:54
 *
 * @author AMarchenkov
 * @since 28.03.2019
 */
public class CountSort {
    public static void main(String[] args) {

        int count = 0, sum = 0;
        do{
            if(count % 3 == 0) continue;
            sum+=count;
        }
        while(count++ < 11);
        System.out.println(sum);

        int[] valueCount = new int[10];
        int[] a = {0, 2, 3, 1, 7, 3, 2, 6, 8, 9, 7, 5, 3, 2, 1, 0, 6, 4, 6, 3, 8, 2};
        for (int i : a) {
            valueCount[i]++;
        }

        for (int j = 0; j < valueCount.length; j++) {
            for (int k = valueCount[j]; k > 0; k--) {
                System.out.print(j + ", ");
            }
        }
    }
}
