import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    static char[][] campus;
    static boolean[][] visited;
    static int cnt = 0;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = str.charAt(j);
                if (campus[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        dfs(x, y);

        if (cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }
    
    //2. dfs
    public static void dfs(int x, int y) {

        visited[x][y] = true;

        if (campus[x][y] == 'P') {
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                if (campus[nx][ny] != 'X') {
                    dfs(nx, ny);
                }
            }
        }
    }
}