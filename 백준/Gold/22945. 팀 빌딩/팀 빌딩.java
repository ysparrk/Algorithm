import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] stats;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());
        stats = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stats[i] = Integer.parseInt(st.nextToken());
        }

        //2. 투포인터
        if (N == 2) {
            System.out.println(0);
            return;
        }

        int s = 0;
        int e = N - 1;
        int maxStat = 0;
        while (s < e) {

            int tmp = Math.min(stats[s], stats[e]) * (e - s - 1);
            
            maxStat = Math.max(maxStat, tmp);
            //작은 값을 움직인다 -> 큰 값은 움직이면 최솟값은 그대로인데 범위만 줄어듬
            if (stats[s] < stats[e]) s++;
            else e--;

        }
        System.out.println(maxStat);
    }
}