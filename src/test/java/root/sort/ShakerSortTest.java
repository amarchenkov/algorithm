package root.sort;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrei Marchenkov (email: andrei.marchenkov@threatrix.io, github: amarchenkov)
 */
class ShakerSortTest {

	private static final Logger LOG = LoggerFactory.getLogger("Algorithms.Sorting");

	@Test
	void testShakerSOrt() {
		int[] unsortedArray = {92, 4, 3, 3, 67, 1, 7, 0, 6, 5, 42, 1, 4, 44, 6, 43, 5, 7, 4, 43, 243, 6, 0, 7, 5};

		ShakerSort.sort(unsortedArray);

		assertArrayEquals(
				new int[]{0, 0, 1, 1, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 42, 43, 43, 44, 67, 92, 243},
				unsortedArray
		);
		LOG.info(Arrays.toString(unsortedArray));
	}
}