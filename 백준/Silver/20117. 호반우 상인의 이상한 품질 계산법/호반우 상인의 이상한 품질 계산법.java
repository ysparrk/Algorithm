import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        if (N % 2 == 0) {
            for (int i = N / 2; i < N; i++) {
                sum += arr[i] * 2;
            }
        } else {
            for (int i = N / 2 + 1; i < N; i++) {
                sum += arr[i] * 2;
            }
            sum += arr[N / 2];
        }
        System.out.println(sum);
    }
}