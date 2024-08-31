import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, K, B;
    private static int[] light;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        light = new int[N + 1];

        for (int i = 0; i < B; i++) {
            int idx = Integer.parseInt(br.readLine());
            light[idx] = 1;
        }

        //2. 슬라이딩 윈도우
        int rlt = B;
        int s = 1;
        int e = K;
        int total = 0;
        for (int i = s; i <= e; i++) {
            total += light[i];
        }

        while (e < N) {
            if (light[s] == 1) {
                total -= 1;
            }

            s++;
            e++;

            total += light[e];
            rlt = Math.min(total, rlt);
        }
        System.out.println(rlt);
    }
}