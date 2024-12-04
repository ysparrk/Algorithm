import java.io.*;

public class Main {

    private static int N, cnt;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i > 0; i--) {
            while (arr[i] <= arr[i - 1]) {
                cnt++;
                arr[i - 1]--;
            }
        }

        System.out.println(cnt);
    }
}