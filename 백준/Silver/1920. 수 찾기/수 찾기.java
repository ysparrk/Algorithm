import java.io.*;
import java.util.*;

public class Main {

    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. input
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stN.nextToken());
        }

        Arrays.sort(A);

        //2. BinarySearch
        int M = Integer.parseInt(br.readLine());
        StringTokenizer stM = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (binarySearch(Integer.parseInt(stM.nextToken()))) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    /**
     * 이진 탐색
     * @param target
     * @return target이 A 배열에 있는지 여부
     */
    public static boolean binarySearch(int target) {
        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (A[mid] == target) {
                return true;
            } else if (target < A[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}