import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        target = new int[N];
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
            sum += target[i];
        }

        int cnt = 0;
        while (sum != 0) {
            int n = 0;
            for (int i = 0; i < N; i++) {
                //나머지가 1인 경우 -> 1 마이너스
                if (target[i] % 2 == 1) {
                    target[i]--;
                    n++;
                }
            }
            if (n > 0) {
                sum -= n;
                cnt += n;
            } else {
                //2로 나누었을 때 1로 남는 수가 없는 경우 -> 전부 2로 나누기
                for (int i = 0; i < N; i++) {
                    target[i] /= 2;
                }
                sum /= 2;
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}