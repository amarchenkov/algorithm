package root;

public class RoundDownImplementation {

    public static void main(String[] args) {
        System.out.println(Math.round(12.86));
        System.out.println(Math.round(12.5));
        System.out.println(Math.round(12.2));
        System.out.println(Math.round(0.86));
        System.out.println(Math.round(0.1));
        System.out.println(Math.round(-12.86));
        System.out.println(Math.round(-12.2));

        System.out.println("--------------------------------");

        System.out.println(round(12.86));
        System.out.println(round(12.5));
        System.out.println(round(12.2));
        System.out.println(round(0.86));
        System.out.println(round(0.1));
        System.out.println(round(-12.86));
        System.out.println(round(-12.2));

        System.out.println("--------------------------------");
        System.out.println(roundTen(4202));
        System.out.println(roundTen(4272));
        System.out.println(roundTen(4278));
        System.out.println(roundTen(-4272));
    }

    private static int round(double src) {
        int smaller = (int) src;
        int bigger = src > 0 ? smaller + 1 : smaller - 1;
        return src - smaller >= bigger - src ? bigger : smaller;
    }

    private static int roundTen(int number) {
        int smaller = (number / 10) * 10;
        int bigger = smaller + 10;

        return  (number - smaller >= bigger - number) ? bigger : smaller;
    }

}
