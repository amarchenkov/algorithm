package root.structures;

public class StackTest {

    private int current;
    private int length;
    private char[] items;

    private StackTest(int length) {
        current = 0;
        this.length = length;
        items = new char[length];
    }

    private char get() {
        return items[--current];
    }

    private void push(char item) {
        items[current++] = item;
    }

    private boolean isEmpty() {
        return current == 0;
    }

    private boolean isFull() {
        return current > length;
    }

    public static void main(String[] args) {
//        String phrase = "улыбок тебе дед мокар";
        String phrase = "потенция";
        StackTest stackTest = new StackTest(phrase.length());
        int i = 0;
        while (!stackTest.isFull() && i < phrase.length()) {
            stackTest.push(phrase.charAt(i++));
        }
        while (!stackTest.isEmpty()) {
            System.out.print(stackTest.get());
        }
        System.out.println("\nBuy");
    }

}
