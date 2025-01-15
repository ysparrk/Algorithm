import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, snake;
    private static int[] H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        snake = Integer.parseInt(st.nextToken());
        H = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(H);
        for (int i = 0; i < N; i++) {
            if (snake >= H[i]) ++snake;
        }
        System.out.println(snake);
    }
}