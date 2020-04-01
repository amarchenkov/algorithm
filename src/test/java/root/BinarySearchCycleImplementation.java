package root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created at 01.04.2020 16:13
 *
 * @author a_marchenkov
 * @since 01.04.2020
 */
public class BinarySearchCycleImplementation {
    private static final Logger LOG = LoggerFactory.getLogger(BinarySearchCycleImplementation.class);

    public static void main(String[] args) {
        int[] data = InputDataUtils.genRandomArray(23);
        LOG.info("Source random array [{}]", Arrays.toString(data));
        Arrays.sort(data);
        LOG.info("Sorted array [{}]", Arrays.toString(data));

        int targetValue = 15;
        int targetIndex = binarySearch(data, targetValue);
        LOG.info("For value ({}) Index = {}", targetValue, targetIndex);
    }

    private static int binarySearch(int[] data, int targetValue) {
        int start = 0;
        int end = data.length - 1;
        while (start <= end) {
            LOG.info("Part from {} to {}", data[start], data[end]);
            int middle = (end + start) / 2;
            LOG.info("Middle at index {} = {}", middle, data[middle]);
            if (data[middle] == targetValue) {
                return middle;
            }
            if (targetValue < data[middle]) {
                end = middle - 1;
            }
            if (targetValue > data[middle]) {
                start = middle + 1;
            }
        }
        return -1;
    }
}
