import java.io.*;
import java.util.*;

public class Main {

    private static int K;
    private static boolean[] sign, visited;
    private static List<String> candidates = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        K = Integer.parseInt(br.readLine());

        sign = new boolean[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            switch (st.nextToken()) {
                case ">":
                    sign[i] = true;
                    break;
                case "<":
                    sign[i] = false;
                    break;
            }
        }

        //2. 백트래킹
        visited = new boolean[10];
        
        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            recur(1, i + "");
            visited[i] = false;
        }

        Collections.sort(candidates);
        System.out.println(candidates.get(candidates.size() - 1));
        System.out.println(candidates.get(0));
    }

    private static void recur(int depth, String str) {
        //종료조건
        if (depth == K + 1) {
            candidates.add(str);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            if (sign[depth - 1] && (int) str.charAt(depth - 1) - 48 <= i) continue;
            if (!sign[depth - 1] && (int) str.charAt(depth - 1) - 48 >= i) continue;

            visited[i] = true;
            recur(depth + 1, str + i);
            visited[i] = false;
        }
    }
}