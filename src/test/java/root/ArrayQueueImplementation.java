package root;

public class ArrayQueueImplementation {
    private final int size;
    private final int[] buffer;

    private int head = -1;
    private int tail = -1;
    private int count = 0;

    public ArrayQueueImplementation(int size) {
        this.size = size;
        this.buffer = new int[size];
    }

    public int poll() {
        if (count == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        count--;
        int value = this.buffer[head];
        head = (head + 1) % size;
        return value;
    }

    public void put(int element) {
        if (count == size) {
            throw new IllegalStateException("Queue is full");
        }
        tail = (tail + 1) % size;
        if (head == -1) {
            head = tail;
        }
        this.buffer[tail] = element;
        count++;
    }

    public int peek() {
        return buffer[head];
    }

    public static void main(String[] args) {
        ArrayQueueImplementation queue = new ArrayQueueImplementation(3);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        System.out.println("From head - " + queue.poll());
        queue.put(4);
        System.out.println("From head - " + queue.poll());
        System.out.println("From head peek - " + queue.peek());
        System.out.println("Bye");
    }

}
