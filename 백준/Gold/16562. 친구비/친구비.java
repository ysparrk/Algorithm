import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, K, tmpW, rlt;
    private static int[] weight;
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weight = new int[N + 1];
        graph = new ArrayList<>(N + 1);
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
        }
        graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(v).add(w);
            graph.get(w).add(v);
        }

        //2. dfs
        for (int i = 1; i < N + 1; i++) {
            if (visited[i]) continue;
            tmpW = weight[i];
            dfs(i);
            rlt += tmpW;
        }

        if (rlt <= K) System.out.println(rlt);
        else System.out.println("Oh no");

    }

    private static void dfs(int s) {
        for (int i = 0; i < graph.get(s).size(); i++) {
            int nxt = graph.get(s).get(i);
            if (visited[nxt]) continue;
            visited[nxt] = true;
            tmpW = Math.min(tmpW, weight[nxt]);
            dfs(nxt);
        }
    }
}