import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. input
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 2. arr에 input
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        Arrays.sort(arr);
        bw.write(arr[0] + " " + arr[n - 1]); // java에는 인덱스 -1이 없다

        bw.flush();
        bw.close();

    }

}