package root.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stones {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String j = r.readLine();
        String s = r.readLine();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (j.indexOf(s.charAt(i)) != -1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
