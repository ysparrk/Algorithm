import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] switchs;
    private static List<Integer>[] infos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        switchs = new int[M + 1];
        infos = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            infos[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            while (x --> 0) {
                int tmp = Integer.parseInt(st.nextToken());
                infos[i].add(tmp);
                switchs[tmp]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (isPossible(i)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean isPossible(int idx) {
        boolean flag = true;

        for (int x : infos[idx]) {
            switchs[x]--;

            if (switchs[x] <= 0) {
                flag = false;
            }
        }

        for (int x : infos[idx]) {
            switchs[x]++;
        }
        return flag;
    }
}