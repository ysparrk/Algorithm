import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. input
        // 공백 있는 숫자열 input
        String[] str = br.readLine().split(" ");
        int n1 = Integer.parseInt(str[0]);
        int n2 = Integer.parseInt(str[1]);
        int n3 = Integer.parseInt(str[2]);
        int ans;

        // 2. 상금 계산
        if (n1 == n2 && n1 == n3) {
            ans = 10000 + n1 * 1000;
        } else if (n1 != n2 && n1 != n3 && n2 != n3 ) {
            Arrays.sort(str);
            ans = 100 * Integer.parseInt(str[2]);
        } else {
            if (n1 == n2 || n1 == n3) {
                ans = 1000 + n1 * 100;
            } else {
                ans = 1000 + n2 * 100;
            }
        }

        // 3. 출력, 숫자 > string형으로 변환
        bw.write(ans + "");

        bw.flush();
        bw.close();
    }
}