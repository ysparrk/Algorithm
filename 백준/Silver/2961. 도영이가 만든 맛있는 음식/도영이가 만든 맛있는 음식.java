import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static long minTaste = Integer.MAX_VALUE;
    private static int[][] ingredient;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        ingredient = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }

        recur(0, 1, 0);

        System.out.println(minTaste);
    }

    private static void recur(int depth, long s, long b) {
        
        //종료조건
        if (depth == N) {
            if (b > 0) {
                minTaste = Math.min(minTaste, Math.abs(s - b));
            }
            return;
        }
        
        recur(depth + 1, s * ingredient[depth][0], b + ingredient[depth][1]);
        recur(depth + 1, s, b);
    }
}