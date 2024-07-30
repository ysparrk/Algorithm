import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] frogsTopic, favorFlowers, graph;
    static int[] flowerTmp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        frogsTopic = new int[N + 1][5];  //선호하는 주제
        favorFlowers = new int[N + 1][2]; // 선호하는 연꽃
        graph = new int[M][3];  // 통나무 그래프
        flowerTmp = new int[N + 1];
        visited = new boolean[N + 1];

        // 1) 선호하는 주제
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 4; j++) {
                frogsTopic[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2) 선호하는 연꽃
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            favorFlowers[i][0] = Integer.parseInt(st.nextToken());
            favorFlowers[i][1] = Integer.parseInt(st.nextToken());

            if (favorFlowers[i][0] == favorFlowers[i][1]) {
                favorFlowers[i][1] = -1;
            }
        }

        // 3) 그래프
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        // 2. 결과 구하기
        dfs(1);
        System.out.println("NO");

    }

    private static void dfs(int fIdx) {
        // 개구리를 flowerTmp에 배치

        // 1) 종료 조건
        if (fIdx == N + 1) {
            // 마지막 개구리까지 다 채우면
            if (is_vaild()) {
                StringBuilder sb = new StringBuilder();
                sb.append("YES\n");
                for (int i = 1; i <= N; i++) {
                    sb.append(flowerTmp[i] + " ");
                }
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }

        // 2) fIdx 개구리가 선호하는 연꽃에 넣기
        for (int j = 0; j < 2; j++) {

            if (favorFlowers[fIdx][j] == -1) {
                continue;
            }

            int candiFlower = favorFlowers[fIdx][j];  // fidx의 후보 연꽃 번호

            if (!visited[candiFlower]) {
                flowerTmp[candiFlower] = fIdx;  // 후보 연꽃에 개구리 넣기
                visited[candiFlower] = true;
                dfs(fIdx + 1);
                visited[candiFlower] = false;
            }
        }
    }

    private static boolean is_vaild() {
        // 개구리를 다 배치시킨 후 확인(통나무의 연꽃의 타깃주제의 선호도가 맞는지 확인)
        for (int i = 0; i < M; i++) {
            int flower1 = graph[i][0];
            int flower2 = graph[i][1];
            int topic = graph[i][2];
            int frog1 = flowerTmp[flower1];
            int frog2 = flowerTmp[flower2];

            if (frogsTopic[frog1][topic] != frogsTopic[frog2][topic]) return false;
        }
        return true;
    }
}