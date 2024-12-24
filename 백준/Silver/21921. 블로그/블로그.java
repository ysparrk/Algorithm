import java.io.*;
import java.util.*;

public class Main {
    private static int N, X;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];

        //누적합
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }

        int max = sum;
        int rlt = 1;
        for (int i = 0; i < N - X; i++) {
            sum += arr[i + X];
            sum -= arr[i];

            if (sum == max) {
                rlt++;
            }

            if (sum > max) {
                rlt = 1;
                max = sum;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(rlt);
        }
    }
}