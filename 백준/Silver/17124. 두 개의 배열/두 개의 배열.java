import java.io.*;
import java.util.*;

public class Main {

    private static int T;
    private static int N, M;
    private static int A[], B[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            //
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            long tmp = 0;
            for (int i = 0; i < N; i++) {
                tmp += binarySearch(0, M - 1, A[i]);

            }
            sb.append(tmp + "\n");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int s, int e, int n) {
        while (s + 1 < e) {
            int mid = (s + e) / 2;

            if (n == B[mid]) {
                return B[mid];
            } else if (n > B[mid]) {
                s = mid;
            } else {
                e = mid;
            }
        }
        
        //값 결정
        if (Math.abs(n - B[s]) <= Math.abs(n - B[e])) {
            return B[s];
        } else {
            return B[e];
        }
    }
}