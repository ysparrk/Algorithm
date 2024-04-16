import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph;
    static int[] tmp_score;
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        tmp_score = new int[N + 1];

        while (true) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            if (node1 == -1 && node2 == -1) {
                break;
            } else {
                graph[node1][node2] = 1;
                graph[node2][node1] = 1;
            }
        }

        //2. 플로이드 워셜
        floyd_warshall();

        //3. result
        find_min();

        System.out.println(sb1);
        System.out.println(sb2);

    }

    //2. 플로이드워셜
    public static void floyd_warshall() {

        //1) 초기 setting
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j && graph[i][j] != 1) {
                    graph[i][j] = 50;
                }
            }
        }

        //2)  i->k k->j 최솟값
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }

                }
            }
        }
    }

    //3. 후보 구하기
    public static void find_min() {

        int min_score = 50;  //후보 점수
        int cnt = 1;         //후보 수
        for (int i = 1; i <= N; i++) {
            int tmp_max = 1;
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] > tmp_max) {
                    tmp_max = graph[i][j];
                }
            }

            if (tmp_max < min_score) {
                cnt = 1;
                min_score = tmp_max;
                sb2.setLength(0); //후보 초기화
                sb2.append(i).append(" ");
            } else if (tmp_max == min_score) {
                sb2.append(i).append(" ");
                cnt++;
            }
        }
        sb2.deleteCharAt(sb2.length() - 1);  //마지막 공백 제거
        sb1.append(min_score + " " + cnt);
    }
}