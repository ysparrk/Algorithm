import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());
            long s = 0;
            long e = (long) Math.sqrt(2 * N - 1);
            long rlt = 0;

            while (s <= e) {
                long mid = (s + e) / 2;
                long sum = mid * (mid + 1) / 2;

                if (sum <= N) {
                    rlt = Math.max(mid, rlt);
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            sb.append(rlt + "\n");
        }
        System.out.println(sb);
    }
}