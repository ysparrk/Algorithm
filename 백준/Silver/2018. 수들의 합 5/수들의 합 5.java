import java.io.*;

public class Main {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int s = 1, e = 1, sum = 1, rlt = 0;
        while (s <= e) {
            if (sum == N) rlt++;
            if (sum < N) {
                e++;
                sum += e;
            } else if (sum >= N) {
                sum -= s;
                s++;
            }
        }
        System.out.println(rlt);
    }
}