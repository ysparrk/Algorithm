import java.io.*;
import java.util.*;

public class Main {

    private static int N, S, cnt;
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //2. 백트래킹
        recur(0, 0);

        if (S == 0) {
            System.out.println(cnt - 1);  //공집합인 경우 제거
        } else {
            System.out.println(cnt);
        }
    }

    private static void recur(int idx, int sum) {

        if (idx == N) {
            if (sum == S) cnt++;
            return;
        }

        recur(idx + 1, sum + nums[idx]); //포함 O
        recur(idx + 1, sum);  //포함 X
    }
}