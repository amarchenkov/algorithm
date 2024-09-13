package root.structures;

/**
 * Created at 11.02.2019 10:28
 *
 * @author AMarchenkov
 * @since 11.02.2019
 */
public class DynamicArray {

	private int[] buffer;

	private int realSize;

	private DynamicArray() {
		this.buffer = new int[4];
	}

	public boolean isEmpty() {
		return realSize == 0;
	}

	public int size() {
		return realSize;
	}

	private void add(int value) {
		if (realSize == buffer.length) {
			int[] tmp = buffer;
			double factor = 1.5;
			buffer = new int[(int) (realSize * factor)];
			System.arraycopy(tmp, 0, buffer, 0, realSize);
		}
		buffer[realSize] = value;
		realSize++;
	}

	public void delete(int index) {
		if (index < 0 || index >= realSize) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if (index == (realSize - 1)) {
			buffer[index] = 0;
		} else {
			for (int i = (index + 1); i < realSize; i++) {
				buffer[i - 1] = buffer[i];
			}
		}
		realSize--;
	}

	public int get(int index) {
		if ((index >= realSize) || (index > (buffer.length - 1))) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return buffer[index];
	}

	public void update(int index, int newValue) {
		if ((index > realSize) || (index > (buffer.length - 1))) {
			throw new ArrayIndexOutOfBoundsException();
		}
		buffer[index] = newValue;
	}

	public static void main(String[] args) {
		final DynamicArray dynamicArray = new DynamicArray();
		dynamicArray.add(1);
		dynamicArray.add(2);
		dynamicArray.add(3);
		dynamicArray.add(4);
		dynamicArray.add(5);
		System.out.println("Bye");
	}
}
