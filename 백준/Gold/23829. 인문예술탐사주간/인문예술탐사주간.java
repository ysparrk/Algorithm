import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, Q;
    private static int[] treeP, spotQ;
    private static long[] prefixSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        treeP = new int[N];
        spotQ = new int[Q];
        long baseD = 0L;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            treeP[i] = Integer.parseInt(st.nextToken());
            baseD += treeP[i] - 1;
        }
        Arrays.sort(treeP);

        int maxXpos = 0;
        for (int i = 0; i < Q; i++) {
            spotQ[i] = Integer.parseInt(br.readLine());
            maxXpos = Math.max(spotQ[i], maxXpos);
        }

        //누적합 구하기
        prefixSum = new long[maxXpos + 1];
        prefixSum[1] = baseD;
        //위치 1 기준 왼쪽, 오른쪽 나무 수
        int left = 0;
        int right = N;
        int idx = 0;
        while (idx < N && treeP[idx] == 1) {
            left++;
            right--;
            idx++;
        }
        for (int i = 2; i <= maxXpos; i++) {
            prefixSum[i] = prefixSum[i - 1] + left - right;
            //현재 위치에서 왼쪽, 오른쪽 나무 수
            while (idx < N && treeP[idx] == i) {
                left++;
                right--;
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int q : spotQ) {
            sb.append(prefixSum[q] + "\n");
        }
        System.out.println(sb);
    }
}