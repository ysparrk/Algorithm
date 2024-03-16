import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] A;
    static int[] B;
    static int rlt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            binarySearch();
            System.out.println(rlt);
        }
    }

    public static void binarySearch() {
        Arrays.sort(B);

        rlt = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = M - 1;
            int idx = 0;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (B[mid] < A[i]) {
                    left = mid + 1;
                    idx = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            rlt += idx;
        }
    }
}