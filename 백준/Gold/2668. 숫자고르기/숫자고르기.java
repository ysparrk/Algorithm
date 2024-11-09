import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] board;
    private static ArrayList<Integer> selected;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. input
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1];
        visited = new boolean[N + 1];
        selected = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        //2. dfs : i -> i로 돌아오는지 확인
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(selected);
        StringBuilder sb = new StringBuilder();
        sb.append(selected.size() + "\n");
        for (int i = 0; i < selected.size(); i++) {
            sb.append(selected.get(i) + "\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int s, int t) {
        if (!visited[board[s]]) {
            visited[board[s]] = true;
            dfs(board[s], t);
            visited[board[s]] = false;
        }

        if (board[s] == t) selected.add(t);
    }
}