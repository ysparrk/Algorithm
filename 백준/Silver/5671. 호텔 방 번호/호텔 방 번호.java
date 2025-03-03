import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(solution(N, M)).append('\n');
        }
        System.out.println(sb);
    }

    private static int solution(int N, int M) {
        int cnt = 0;

        for (int n = N; n <= M; n++) {
            if (check(n)) cnt++;
        }
        return cnt;
    }

    private static boolean check(int n) {
        int[] visited = new int[10];

        while (n != 0) {
            if (visited[n % 10] == 1) return false;
            visited[n % 10]++;
            n /= 10;
        }
        return true;
    }
}