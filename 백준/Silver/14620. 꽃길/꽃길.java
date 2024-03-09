import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] flower;
    static boolean[][] visited;
    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
    static int minCost = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());
        flower = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                flower[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);
        System.out.println(minCost);

    }

    //2. 백트래킹
    static void backtracking(int cost, int cnt) {

        if (cnt == 3) {
            minCost = Math.min(minCost, cost);

        } else {
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    if (check(i, j)) {
                        int temp = tempCost(i, j);
                        backtracking(cost + temp, cnt + 1);
                        backVist(i, j);
                    }
                }
            }
        }
    }

    //2-1. 꽃을 심을 수 있는지 확인
    static boolean check(int x, int y) {
        for (int i = 0; i < 5; i++) {
            int kx = x + dx[i];
            int ky = y + dy[i];

            if (visited[kx][ky]) {
                return false;
            }
        }
        return true;
    }

    //2-2. visited 표시 되돌리기
    static void backVist(int x, int y) {
        for (int i = 0; i < 5; i++) {
            int kx = x + dx[i];
            int ky = y + dy[i];

            visited[kx][ky] = false;
        }
    }

    //2-3. 해당 지점에서의 비용 구하기
    static int tempCost(int x, int y) {
        int temp = 0;
        for (int i = 0; i < 5; i++) {
            int kx = x + dx[i];
            int ky = y + dy[i];

            temp += flower[kx][ky];
            visited[kx][ky] = true;
        }
        return temp;
    }
}