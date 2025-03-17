import java.io.*;

public class Main {

    private static String S;
    private static int lenS;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        lenS = S.length();

        visited = new boolean[51];
        dfs(0, "", 0);
    }

    private static void dfs(int idx, String rlt, int maxN) {
        if (idx == lenS) {
            //종료조건
            for (int i = 1; i <= maxN; i++) {
                if (!visited[i]) return;
            }
            System.out.println(rlt.trim());
            System.exit(0);
            return;
        }

        //한자리
        String tmp = S.substring(idx, idx + 1);
        int num = Integer.parseInt(tmp);

        if (!visited[num]) {
            visited[num] = true;
            maxN = Math.max(maxN, num);
            dfs(idx + 1, rlt + " " + tmp, maxN);
            visited[num] = false;
        }

        if (idx < lenS - 1) {
            //두자리
            tmp = S.substring(idx, idx + 2);
            num = Integer.parseInt(tmp);
            if (num < 51 && !visited[num]) {
                visited[num] = true;
                maxN = Math.max(maxN, num);
                dfs(idx + 2, rlt + " " + tmp, maxN);
                visited[num] = false;
            }
        }
    }
}