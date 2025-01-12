import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, max, rlt;
    private static int[] costs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());
        costs = new int[N];

        int total = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            total += costs[i];
            max = Math.max(max, costs[i]);
        }

        M = Integer.parseInt(br.readLine());

        //2. 이진탐색
        if (total <= M) {
            System.out.println(max);
        } else {
            binarySearch();
            System.out.println(rlt);
        }
    }

    private static void binarySearch() {
        int s = 0;
        int e = max;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (isPossible(mid)) {
                s = mid + 1;
                rlt = mid;
            } else {
                e = mid - 1;
            }
        }
    }

    private static boolean isPossible(int target) {
        int tmp = 0;

        for (int i = 0; i < N; i++) {
            tmp += Math.min(costs[i], target);

            if (tmp > M) return false;
        }
        return true;
    }
}