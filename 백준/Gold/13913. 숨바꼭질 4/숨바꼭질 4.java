import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[] visited = new int[100001];
    static int[] parent = new int[100001];  // 방문 전 노드 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. input
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 2. bfs
        if (N == K) {
            System.out.println(0);
            System.out.println(N);
        } else {
            bfs(N);
            StringBuilder sb = new StringBuilder();
            sb.append((visited[K] - 1) + "\n");  //최단시간

            Stack<Integer> stack = new Stack<>();
            int p = K;  // K지점부터 따라가기

            while (p != N) {
                stack.push(p);
                p = parent[p];
            }
            stack.push(N);

            while (!stack.isEmpty()) {
                sb.append(stack.pop() + " ");
            }

            System.out.println(sb);
        }
    }

    private static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();

        // 시작
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {

            int x = queue.poll();

            if (x - 1 >= 0 && visited[x - 1] == 0) {
                queue.add(x - 1);
                visited[x - 1] = visited[x] + 1;
                parent[x - 1] = x;
            }

            if (x + 1 <= 100000 && visited[x + 1] == 0) {
                queue.add(x + 1);
                visited[x + 1] = visited[x] + 1;
                parent[x + 1] = x;
            }

            if (x * 2 <= 100000 && visited[x * 2] == 0) {
                queue.add(x * 2);
                visited[x * 2] = visited[x] + 1;
                parent[x * 2] = x;
            }

            if (visited[K] != 0) {
                return;
            }
        }
    }
}