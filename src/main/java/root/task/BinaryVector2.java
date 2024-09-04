package root.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryVector2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] vector = new  int[n];

        String data;
        int i = 0;
        while ((data = bufferedReader.readLine()) != null && i < n) {
            vector[i] = Integer.parseInt(data);
            i++;
        }

        int best = 0;
        int current = 0;
        for (int v : vector) {
            if (v > 0) {
                current++;
                best = Math.max(best, current);
            } else {
                current = 0;
            }
        }
        System.out.println(best);
    }
}
