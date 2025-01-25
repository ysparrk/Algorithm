import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] parent;
    private static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        tree = new ArrayList[N + 1];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            tree[a].add(b);
            tree[b].add(a);
        }

        boolean[] visited = new boolean[N];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int node : tree[v]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parent[node] = v;
                }
            }
        }

        //result
        for (int i = 1; i < N; i++) {
            System.out.println(parent[i] + 1);
        }

    }
}