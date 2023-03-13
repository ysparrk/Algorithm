import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 크기 n인 arr 배열 생성
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 2. arr에 input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 3. 결과 출력
        int v = Integer.parseInt(br.readLine());
        br.close();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == v) cnt++;
        }
        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }
}