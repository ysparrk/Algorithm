import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());

        int start = 1;
        int end = M * 5;
        int rlt = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;

            for (int i = 5; i <= mid; i *= 5) {
                cnt += mid / i;  //5의 개수
            }
            if (cnt > M) {
                end = mid - 1;
            } else if (cnt == M) {
                end = mid - 1;
                rlt = 1;
            } else {
                start = mid + 1;
            }
        }

        if (rlt == 0) {
            System.out.println(-1);
        } else {
            System.out.println(start);
        }
    }
}