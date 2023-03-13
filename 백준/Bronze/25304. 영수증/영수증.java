import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. input
        int x = Integer.parseInt(br.readLine()); // 총 금액
        int n = Integer.parseInt(br.readLine()); // 물건 종류 수

        // 2. for문
        int sum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sum += a * b;
        }

        // 3. 결과 출력
        if (sum == x) {
            bw.write("Yes");
        }
        else {
            bw.write("No");
        }

        bw.flush();
        bw.close();

    }
}