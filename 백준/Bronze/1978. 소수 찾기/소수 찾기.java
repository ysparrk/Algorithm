import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        br.readLine();  //N 사용X

        //1.
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            if (isPrime(num)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    //2. 소수 판별 메서드
    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        //2~ 제곱근으로 나누어 떨어지지 않으면 -> 소수
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}