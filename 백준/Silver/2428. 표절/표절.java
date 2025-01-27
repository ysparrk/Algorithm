import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static long[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        size = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            size[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(size);

        long cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            cnt += (binarySearch(i) - i);
        }
        System.out.println(cnt);

    }

    private static int binarySearch(int idx) {
        //해당 사이즈 보다 90프로 더 큰 파일의 최초 위치
        int s = idx;
        int e = N - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (size[mid] * 0.9 <= size[idx]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return s - 1;
    }
}