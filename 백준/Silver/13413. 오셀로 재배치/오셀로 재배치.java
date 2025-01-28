import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String cur = br.readLine();
            String target = br.readLine();

            sb.append(findMin(cur, target, N) + "\n");
        }
        System.out.println(sb);

    }

    private static int findMin(String cur, String target, int N) {
        int W = 0;
        int B = 0;

        for (int i = 0; i < N; i++) {
            if (cur.charAt(i) != target.charAt(i)) {
                if (cur.charAt(i) == 'W') B++;
                else W++;
            }
        }
        return Math.max(W, B);
    }
}