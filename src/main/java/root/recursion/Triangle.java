package root.recursion;

public class Triangle {

    private int getElementByNumber(int n) {
        System.out.println("Entering - " + n);
        if (n == 1) {
            System.out.println("Returning 1");
            return 1;
        }
        int temp = n + getElementByNumber(n - 1);
        System.out.println("Returning " + temp);
        return temp;
    }

    public static void main(String[] args) {
        System.out.println("Getting N element");
        int n = 10;
        System.out.println(new Triangle().getElementByNumber(n));
        System.out.println("Bye");
    }

}
