import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int team = 0;

        //N에서 k를 몇명이나 뺄 것인가
        for (int k = 0; k <= K; k++) {
            int n = N - k;
            int m = M - (K - k);

            if (n <= 0 || m <= 0) continue;
            team = Math.max(team, Math.min(n/2, m));
        }
        System.out.println(team);
    }
}