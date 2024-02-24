import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[] visited = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        //1. input
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
        System.out.println(visited[K] - 1);

    }
    
    /**
     * 2. bfs
     * 방문하지 않은 인덱스에 대해 second 갱신
     */
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = 1;
        int x;
        while (!queue.isEmpty()) {

            x = queue.poll();

            if (x - 1 >= 0 && visited[x - 1] == 0) {
                queue.add(x - 1);
                visited[x - 1] = visited[x] + 1;
            }

            if (x + 1 <= 100000 && visited[x + 1] == 0) {
                queue.add(x + 1);
                visited[x + 1] = visited[x] + 1;
            }

            if (x * 2 <= 100000 && visited[x * 2] == 0) {
                queue.add(x * 2);
                visited[x * 2] = visited[x] + 1;
            }

            if (visited[K] != 0) {
                return;
            }
        }
    }
}