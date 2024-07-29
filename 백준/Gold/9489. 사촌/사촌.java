import java.io.*;
import java.util.*;

public class Main {

    static int N, K, kIdx;
    static int[] idxs, parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        // 1. input
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (N == 0 && K == 0) break;

            idxs = new int[N];
            parent = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                idxs[i] = Integer.parseInt(st.nextToken());

                if (idxs[i] == K) kIdx = i;

            }

            // 2. 결과
            find_cousin();

        }
    }

    private static void find_cousin() {
        int rlt = 0;

        // 1) parent idx 기록
        parent[0] = -1;  //루트 노드 부모X

        int parentIdx = 0;
        for (int i = 1; i < N; i++) {
            parent[i] = parentIdx;

            // 연속된 순열이 아니라면
            if (i < N - 1 && (idxs[i] + 1) != idxs[i + 1]) parentIdx++;
        }


        // 2) 부모는 다르지만, 부모의 부모가 같은 경우
        for (int i = 1; i < N; i++) {
            if (parent[kIdx] != parent[i] && parent[parent[kIdx]] == parent[parent[i]]) rlt++;
        }

        System.out.println(rlt);
    }
}