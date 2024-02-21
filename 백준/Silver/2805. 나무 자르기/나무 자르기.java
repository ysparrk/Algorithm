import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //1. input
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (max < tree[i]) {
                max = tree[i];
            }
        }

        //2. Binary Search
        int start = 0;
        int end = max + 1;
        while (start < end) {
            int mid = (start + end) / 2;

            long dis = 0;
            for (int t : tree) {
                if (t > mid) {
                    dis += (t - mid);
                }
            }

            //범위 조절, 최댓값 갱신
            if (dis >= M) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        System.out.println(start - 1); //Upper Bound
    }
}