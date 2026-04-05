import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            sum += t;
            tree[i] = t;
        }


        if (sum % 3 != 0) {
            System.out.println("NO");
        } else {
            int cnt = 0;  //2를 붓는 횟수
            for (int t : tree) {
                cnt += t / 2;
            }
            if (sum / 3 <= cnt) {
                System.out.println("YES");
            } else {
                //총 걸리는 일수(sum/3)가 2를 붓는 횟수보다 크면 NO
                System.out.println("NO");
            }
        }
    }
}