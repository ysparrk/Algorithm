import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int INF = 987654321;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = -1;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(arr[i], right);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (isPossible(mid) <= M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right);
    }

    private static int isPossible(int target) {
        int min = INF;
        int max = -INF;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (max - min > target) {
                cnt++;
                max = -INF;
                min = INF;
                i--;
            }
        }
        return cnt;
    }
}