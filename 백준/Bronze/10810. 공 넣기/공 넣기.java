import java.io.*;
import java.util.*;
// 바구니 총 n개, 1~n까지 번호
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 바구니 개수
        int m = Integer.parseInt(st.nextToken()); // m번 공을 넣는다

        // 1. 크기 n, 0이 들어있는 basket 배열 생성
        int[] basket = new int[n];

        // 2.
        for (int x = 0; x < m; x++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken()) - 1; // 시작
            int j = Integer.parseInt(st.nextToken()) - 1; // 끝
            int k = Integer.parseInt(st.nextToken()); // 공 번호

            for (int y = i; y <= j; y++) {
                basket[y] = k;
            }
        }
        br.close();

        // 3.
        for (int z = 0; z < n; z++) {
            bw.write(basket[z] + " ");
        }
        bw.flush();
        bw.close();
    }
}