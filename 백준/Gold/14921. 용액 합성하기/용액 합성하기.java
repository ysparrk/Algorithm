import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] liquid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        liquid = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        int left = 0;
        int right = N - 1;
        long rlt = Integer.MAX_VALUE;
        while (left < right) {
            long tmp = liquid[left] + liquid[right];

            if (Math.abs(tmp) < Math.abs(rlt)) rlt = tmp;

            if (tmp == 0) break;
            else if (tmp > 0) right--;
            else left++;
        }
        System.out.println(rlt);
    }
}