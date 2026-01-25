import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] nums, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        result = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        result[N] = -1;  //마지막 원소는 비교 대상이 없음

        for (int i = N - 1; i >= 1; i--) {
            if (nums[i] != nums[i + 1]) {
                result[i] = i + 1;
            } else {
                result[i] = result[i + 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);
    }
}