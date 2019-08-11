package root.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine()); //1000000

        int prev = -1;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(bufferedReader.readLine());
            if (res.isEmpty() || current != prev) {
                res.add(current);
            }
            prev = current;
        }
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}
