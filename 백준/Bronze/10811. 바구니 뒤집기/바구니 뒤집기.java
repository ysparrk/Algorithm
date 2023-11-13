import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 배열 설정 후 초기 상태 만들기
        int[] basket = new int[n];
        for(int i = 0; i < n; i++) {
            basket[i] = i + 1;
        }

        for(int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) -1;
            int j = Integer.parseInt(st.nextToken()) -1;

            while (i < j) {
                int temp = basket[i];
                basket[i++] = basket[j];
                basket[j--] = temp;
            }
        }
        br.close();
        
        for (int b : basket) {
            bw.write(b+" ");
        }
        bw.flush();
        bw.close();
    }
}