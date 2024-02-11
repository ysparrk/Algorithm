import java.io.*;
import java.util.*;

public class Main {
    public static int[][] graph;
    public static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[v][e] = 1;
            graph[e][v] = 1;
        }

        bfs(1);
    }


    /**
     * 2. BFS
     * start를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수 출력
     * @param start
     */
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        visited[start] = 1;
        queue.offer(start);

        while (!queue.isEmpty()) {

            int x = queue.poll();

            //방문하지 않았다면, 다음 방문할 지점 찾기
            for (int i = 0; i < graph[x].length; i++) {
                if (graph[x][i] == 1 && visited[i] == 0) {
                    queue.offer(i);
                    visited[i] = 1;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}