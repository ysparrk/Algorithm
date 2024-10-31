import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, X, Y, rlt;
    private static List<Integer>[] graph;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        //1. input
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[p].add(c);
            graph[c].add(p);
        }
        
        //2. dfs
        rlt = -1;
        dfs(X, 0);
        System.out.println(rlt);
    }

    private static void dfs(int cur, int cnt) {

        if (cur == Y) {
            rlt = cnt;
            return;
        }

        visited[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) {
            int nxt = graph[cur].get(i);
            if (visited[nxt]) continue;
            dfs(nxt, cnt + 1);
        }
    }
}