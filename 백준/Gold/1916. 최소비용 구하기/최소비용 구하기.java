import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] dist;
    private static boolean[] visited;
    private static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];  //인접리스트

        dist = new int[N + 1];  //시작점 -> 최단거리
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[target]);

    }

    private static void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int to = node.to;

            if (visited[to]) continue;

            visited[node.to] = true;
            for (Node next : graph[to]) {
                if (dist[next.to] >= dist[to] + next.weight) {
                    dist[next.to] = dist[to] + next.weight;
                    queue.add(new Node(next.to, dist[next.to]));
                }
            }
        }

    }
}

class Node implements Comparable<Node> {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }


    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}