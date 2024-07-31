import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// edge 정보 클래스
class Edge implements Comparable<Edge> {
    int a;
    int b;
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.a = v1;
        this.b = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return weight - e.weight;  // 정렬
    }
}


public class Main {

    private static int V, E;
    private static int[] parent;  //부모 정보
    static PriorityQueue<Edge> pq; // 간선 정보 저장

    // 2. Union-Find
    // 1) 노드의 부모 찾기
    private static int find_parent(int x) {

        if (parent[x] == x) return x;

        parent[x] = find_parent(parent[x]);
        return parent[x];
    }

    // 2) 두 원소의 집합 합치기 -> 부모 같게 만들기
    private static void union_parent(int a, int b) {
        a = find_parent(a);
        b = find_parent(b);

        // 작은 원소가 부모
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    // 3) 사이클 확인 -> 같은 부모 X -> 사이클 X
    private static boolean same_parent(int a, int b) {
        return find_parent(a) == find_parent(b);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. input
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        parent = new int[V + 1];

        //1) 부모 노드
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        //2) 간선 정보
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(v1, v2, weight));
        }


        // 3. result
        int rlt = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            int a = edge.a;
            int b = edge.b;

            if (!same_parent(a, b)) {
                union_parent(a, b);
                rlt += edge.weight;
            }
        }
        System.out.println(rlt);
    }
}