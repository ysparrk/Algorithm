import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. arr에 input
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 2. max 값 찾기
        int max = arr[0];
        int idx = 0;
        for (int i = 0; i < 9; i++){
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
        }
        br.close();
        bw.write(max + "\n" + (idx + 1));

        bw.flush();
        bw.close();
    }
}