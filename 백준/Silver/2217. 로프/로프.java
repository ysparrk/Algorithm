import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());

        Integer[] rope = new Integer[N];

        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope, Collections.reverseOrder());

        int rlt = 0;
        for (int i = 0; i < N; i++) {
            rlt = Math.max(rlt, rope[i] * (i + 1));
        }

        System.out.println(rlt);
    }
}