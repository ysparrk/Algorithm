import java.io.*;
public class Main {
    private static String X;
    private static int N, nLen, min = Integer.MAX_VALUE;
    private static int[] nums, selected;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = br.readLine();

        N = Integer.parseInt(X);
        nLen = X.split("").length;

        nums = new int[nLen];
        selected = new int[nLen];
        visited = new boolean[nLen];

        for (int i = 0; i < nLen; i++) {
            nums[i] = Integer.parseInt(X.split("")[i]);
        }

        backtracking(0);
        if (min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }

    private static void backtracking(int depth) {

        if (depth == nLen) {
            //배열 -> 정수로 변환
            String tmp = "";

            for (int i = 0; i < nLen; i++) {
                tmp += selected[i];
            }

            int tmpN = Integer.parseInt(tmp);
            if (N < tmpN) {
                min = Math.min(min, tmpN);
            }
            return;
        }

        for (int i = 0; i < nLen; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = nums[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }

    }
}