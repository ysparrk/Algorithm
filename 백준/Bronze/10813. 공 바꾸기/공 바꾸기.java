import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 1. input
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 2. basket 배열 만들기
        int[] basket = new int[n];
        for (int i = 0; i < n; i++) {
            basket[i] = i + 1;
        }

        // 3. 값 교환
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int temp = basket[a -1];
            basket[a - 1] = basket[b - 1];
            basket[b - 1] = temp;
        }
        br.close();

        // 4. 출력
        for (int i = 0; i < n; i++) {
            bw.write(basket[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}