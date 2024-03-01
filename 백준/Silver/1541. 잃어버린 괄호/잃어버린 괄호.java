import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minus = new StringTokenizer(br.readLine(), "-");

        /**
         * 최솟값 구하기 -> 최대한 더해서 뺀다!
         * 1. "-" 를 기준으로 split
         * 2. 나눠진 구간 다 더해서 빼기
         */

        int sum = Integer.MAX_VALUE;
        while (minus.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");

            while (plus.hasMoreTokens()) {
                temp += Integer.parseInt(plus.nextToken());
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}