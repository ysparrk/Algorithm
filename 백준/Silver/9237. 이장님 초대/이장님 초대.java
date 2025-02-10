import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static Integer[] T;
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        T = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(T, Comparator.reverseOrder());

         int rlt = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            rlt = Math.max(rlt, T[i] + i + 1);
        }

        System.out.println(rlt + 1);
    }
}