import java.io.*;

public class Main {

    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int t = 0; t < N; t++) {
            if(checkIsGroup(br.readLine())) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean checkIsGroup(String str) {
        boolean[] visited = new boolean[26];

        int now = str.charAt(0) - 97;
        visited[now] = true;
        for (int i = 1; i < str.length(); i++) {
            int next = str.charAt(i) - 97;
            
            if (next == now) continue;
            else {
                if (visited[next]) return false;
                else {
                    visited[next] = true;
                    now = next;
                }
            }
        }
        return true;
    }
}