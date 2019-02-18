package root.search;

/**
 * Created at 14.02.2019 18:29
 *
 * @author AMarchenkov
 * @since 14.02.2019
 */
public class LogSearch {
    public static void main(String[] args) {
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{4};
        int[] arr3 = new int[]{12, 34};
        int[] arr4 = new int[]{12, 34, 66, 78, 99, 100, 200, 300, 444, 666, 777, 10000, 122000};


        int searched = 10000;
        int searchIn[] = arr4;

        int start = 0;
        int end = searchIn.length - 1;

        while (start <= end) {
            int middle = start + ((end - start) / 2);
            System.out.println("Middle = " + searchIn[middle]);
            if (searchIn[middle] == searched) {
                System.out.println("Position = " + middle);
                break;
            }
            if (searched > searchIn[middle]) {
                start = middle + 1;
                System.out.println(searched + " > " + searchIn[middle]);
                continue;
            }
            if (searched < searchIn[middle]) {
                System.out.println(searched + " < " + searchIn[middle]);
                end = middle - 1;
            }
        }
    }
}
