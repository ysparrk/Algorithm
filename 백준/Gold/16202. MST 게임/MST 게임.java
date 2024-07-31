import java.io.*;
import java.util.*;

// edge 정보 클래스
class Edge {
    int a;
    int b;
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.a = v1;
        this.b = v2;
        this.weight = weight;
    }
}


public class Main {

    private static int V, E, K;
    private static int[] parent;
    private static ArrayList<Edge> queue;

    private static int kruskal() {

        int w = 0;
        int firstIdx = -1;
        int cnt = 0;

        for (int i = 0; i < queue.size(); i++) {
            Edge edge = queue.get(i);

            int a = edge.a;
            int b= edge.b;

            if (!same_parent(a, b)) {
                union_parent(a, b);
                w += edge.weight;
                cnt++;

                if (firstIdx == -1) firstIdx = i;
            }
        }

        //MST는 간선이 V-1개 있어야 한다.
        if (cnt == V - 1) {
            queue.remove(firstIdx);
            return w;
        }
        return -1;
    }

    private static int find_parent(int x) {
        if (parent[x] == x) return x;

        parent[x] = find_parent(parent[x]);
        return parent[x];
    }

    // 2) 집합 합치기
    private static void union_parent(int a, int b) {
        a = find_parent(a);
        b = find_parent(b);

        if (a <= b) parent[b] = a;
        else parent[a] = b;
    }

    // 3) 사이클 확인(같은 집합인지 확인)
    private static boolean same_parent(int a, int b) {
        return find_parent(a) == find_parent(b);
    }
    
    private static void init_parent() {
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. input
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        queue = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            queue.add(new Edge(a, b, i));
        }

        // 2. K턴 돌리기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int rltWeight = kruskal();

            if (rltWeight == -1) {
                for (int j = i; j < K; j++) {
                    sb.append(0 + " ");
                }
                break;
            }
            else {
                sb.append(rltWeight + " ");
                init_parent();
            }

        }
        System.out.println(sb);
    }
}