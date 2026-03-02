import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static class Node {
        int next;
        int distance;

        public Node(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }
    }

    private static int N, M;
    private static ArrayList<ArrayList<Node>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            tree.get(a).add(new Node(b, d));
            tree.get(b).add(new Node(a, d));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(bfs(s, e)).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int start, int end) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        visited[start] = true;
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.next == end) {
                return cur.distance;
            }

            for (Node next : tree.get(cur.next)) {
                if (!visited[next.next]) {
                    visited[next.next] = true;
                    queue.add(new Node(next.next, cur.distance + next.distance));
                }
            }
        }
        return -1;
    }
}