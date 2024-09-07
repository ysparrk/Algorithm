import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] hi, arc;
    private static long hiWin, arcWin, tie;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        hi = new int[N];
        arc = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hi[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arc[i] = Integer.parseInt(st.nextToken());
        }

        //2.이분탐색
        Arrays.sort(hi);
        for (int i = 0; i < M; i++) {
            binarySearch(arc[i]);
        }
        System.out.println(hiWin + " " + arcWin + " " + tie);
    }

    private static void binarySearch(int m) {
        //m이 HI팀을 몇명까지 이길 수 있는지 확인
        int s = 0;
        int e = N - 1;

        //비기는 지점
        int tie_s = N;  //비기는 시작점 -> 오른쪽에서 오면서, 언제까지 지거나 비겨?
        int tie_e = -1;  //비기는 끝점  -> 왼쪽에서 오면서, 언제까지 이기거나 비겨?
        while (s <= e) {
            int mid = (s + e) / 2;

            //실력비교
            if (m >= hi[mid]) {
                s = mid + 1;
                tie_e = mid;
            } else {
                e = mid - 1;
            }
        }

        s = 0;
        e = N - 1;
        while (s <= e) {
            int mid = (s + e) / 2;

            //실력비교
            if (m > hi[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
                tie_s = mid;
            }
        }

        tie += (tie_e - tie_s + 1);
        hiWin += N - tie_e - 1;
        arcWin += tie_s;
    }
}