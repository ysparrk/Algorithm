import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, rlt;
    private static ArrayList<Integer>[] friends;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friends = new ArrayList[N];
        visited = new boolean[N];
        rlt = 0;

        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        //2. dfs
        for (int i = 0; i < N; i++) {
            if (rlt == 0) {
                dfs(i, 1);
            }
        }
        System.out.println(rlt);
    }

    private static void dfs(int start, int depth) {
        if (depth == 5) {
            rlt = 1;
            return;
        }

        visited[start] = true;
        for (int i = 0; i < friends[start].size(); i++) {
            int next = friends[start].get(i);
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[start] = false;
    }
}