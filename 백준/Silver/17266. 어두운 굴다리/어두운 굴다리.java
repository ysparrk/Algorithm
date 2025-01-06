import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        X = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = N;
        int rlt = 0;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(isPossible(mid)) {
                rlt = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        System.out.println(rlt);
    }

    private static boolean isPossible(int target) {
        int tmp = 0;

        for(int i = 0; i < X.length; i++) {

            if(X[i] - target <= tmp) {
                tmp = X[i] + target;
            } else {
                return false;
            }
        }
        if (N - tmp <= 0) {
            return true;
        } else {
            return false;
        }
    }
}