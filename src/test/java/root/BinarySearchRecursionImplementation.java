package root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created at 01.04.2020 15:53
 *
 * @author a_marchenkov
 * @since 01.04.2020
 */
public class BinarySearchRecursionImplementation {
    private static final Logger LOG = LoggerFactory.getLogger(BinarySearchRecursionImplementation.class);

    public static void main(String[] args) {
        int[] data = InputDataUtils.genRandomArray(17);
        LOG.info("Source random array [{}]", Arrays.toString(data));
        Arrays.sort(data);
        LOG.info("Sorted array [{}]", Arrays.toString(data));

        int targetValue = 15;
        int targetIndex = binarySearch(data, targetValue, 0, data.length - 1);
        LOG.info("For value ({}) Index = {}", targetValue, targetIndex);
    }

    private static int binarySearch(int[] data, int targetValue, int start, int end) {
        LOG.info("Part from {} to {}", data[start], data[end]);
        if (end < start) {
            return -1;
        }
        int middle = (start + end) / 2;
        LOG.info("Middle at index {} = {}", middle, data[middle]);
        if (data[middle] == targetValue) {
            return middle;
        }
        if (targetValue < data[middle]) {
            return binarySearch(data, targetValue, start, middle - 1);
        }
        if (targetValue > data[middle]) {
            return binarySearch(data, targetValue, middle + 1, end);
        }
        return -1;
    }
}
