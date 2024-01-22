/**
 * 소인수분해
 * -> 2*5의 개수
 * -> 5의 개수
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (N >= 5) {
            cnt += N / 5;   //5로 나눈 몫 더하기
            N /= 5;
        }
        System.out.println(cnt);

    }
}