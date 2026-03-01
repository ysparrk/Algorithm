import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int num, totalCount;
    private static ArrayList<Integer>[] dst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dst = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            dst[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dst[a].add(b);
            dst[b].add(a);
        }

        bfs(1);
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        int[] cnt = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        int max = Integer.MIN_VALUE;

        queue.offer(x);
        visited[x] = true;
        while (!queue.isEmpty()) {
            x = queue.poll();
            for (int n : dst[x]) {
                if (!visited[n]) {
                    queue.offer(n);
                    visited[n] = true;
                    cnt[n] = cnt[x] + 1;
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                num = i;
                totalCount = 1;
            } else if (max == cnt[i]) {
                totalCount++;
            }
        }
        System.out.println(num + " " + cnt[num] + " " + totalCount);
    }
}