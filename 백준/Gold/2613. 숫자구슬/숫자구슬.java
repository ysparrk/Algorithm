import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        int s = 0;   //그룹합 최댓값의 최솟값
        int e = 0;  //그룹합 최댓값의 최댓값

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            s = Math.max(s, nums[i]);
            e += nums[i];
        }

        //2. 이분탐색
        //1) s 찾기
        StringBuilder sb = new StringBuilder();
        while (s <= e) {
            int mid = (s + e) / 2;

            int cnt = checkM(mid);

            if (cnt > M) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        sb.append(s).append("\n");


        //2) 그룹합 최댓값이 s가 되게 하는 구슬의 조합
        int tmpSum = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            tmpSum += nums[i];
            if (tmpSum > s) {
                M--;
                tmpSum = nums[i];
                sb.append(cnt + " ");
                cnt = 1;
            } else cnt++;

            if (M == N - i) break;
        }

        while (M --> 0) {
            sb.append(cnt + " ");
            cnt = 1;
        }
        System.out.println(sb);
    }

    private static int checkM(int mid) {
        //mid값이 그룹합의 최댓값인 경우 만들 수 있는 그룹의 수
        int tmpSum = 0;
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            tmpSum += nums[i];
            if (tmpSum > mid) {
                cnt++;
                tmpSum = nums[i];
            }
        }
        return cnt;
    }
}