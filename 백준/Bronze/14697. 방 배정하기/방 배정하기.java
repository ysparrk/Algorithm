import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        //완전탐색
        for (int a = 0; a <= (N / A) + 1; a++) {
            for (int b = 0; b <= (N / B) + 1; b++) {
                for (int c = 0; c <= (N / C) + 1; c++) {

                    if (A * a + B * b + C * c == N) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}