import java.io.*;
import java.util.*;

public class Main {

    private static int N, H;
    private static int[] cave;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        cave = new int[H + 1];

        //1. imos
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (i % 2 != 0) {
                cave[1] += 1;
                cave[n + 1] += -1;
            } else {
                cave[H - n + 1] += 1;
            }
        }

        for (int i = 1; i <= H; i++) {
            cave[i] += cave[i - 1];
        }

        //2. 정렬
        Arrays.sort(cave);

        //3. 최솟값 개수 찾기
        int cnt = 1;
        for (int i = 2; i <= H; i++) {
            if (cave[1] == cave[i]) cnt++;
            else break;
        }

        System.out.println(cave[1] + " " + cnt);
    }
}