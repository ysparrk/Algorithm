import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] A;
    private static long rlt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rlt += Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        for (int i = 0; i < N; i++) {
            rlt += A[i] * i;
        }

        System.out.println(rlt);
    }
}