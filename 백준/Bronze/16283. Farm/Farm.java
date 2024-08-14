import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        //완전탐색
        int x = 0, y = 0, cnt = 0;
        for (int i = 1; i < N; i++) {

            if (A * i + B * (N - i) == W) {
                cnt++;
                x = i;
                y = N - i;
            }
        }
        if (cnt == 1) System.out.println(x + " " + y);
        else System.out.println(-1);
    }
}