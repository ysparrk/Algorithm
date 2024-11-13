import java.io.*;
import java.util.*;

public class Main {

    private static int N, K, rlt;
    private static int[] A;
    private static int[][] R, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        R = new int[K][N];
        M = new int[K][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                R[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2. 백트래킹
        recur(0, 0);
        System.out.println(rlt);
    }

    private static void recur(int cur, int sum) {
        //종료조건
        if (cur == K) {
            rlt = Math.max(rlt, sum);
            return;
        }

        //다음 날
        for (int i = 0; i < N; i++) {
            //R선택
            if (A[i] == 0) continue;
            A[i]--;

            for (int j = 0; j < N; j++) {
                //M선택
                if (A[j] == 0) continue;

                A[j]--;
                recur(cur + 1, sum + R[cur][i] + M[cur][j]);
                A[j]++;
            }
            A[i]++;
        }
    }
}