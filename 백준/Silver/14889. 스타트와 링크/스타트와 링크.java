import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] arr;
    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeTeam(0, 0);
        System.out.println(result);

    }

    //팀 나누기
    private static void makeTeam(int idx, int cnt) {
        //팀 조합 완성
        if (cnt == N / 2) {
            getScore();
            return;
        }

        for (int i = idx; i < N; i++) {
            //i가 start에 포함되지 않았다면
            if (!visited[i]) {
                visited[i] = true;
                makeTeam(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    //두 팀의 점수 차 계산
    private static void getScore() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                //ij 가 teamStart에 포함된다면
                if (visited[i] && visited[j]) {
                    teamStart += (arr[i][j] + arr[j][i]);
                } else if (!visited[i] && !visited[j]) {
                    teamLink += (arr[i][j] + arr[j][i]);
                }
            }
        }

        int score = Math.abs(teamStart - teamLink);
        result = Math.min(result, score);
    }

}