import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. input
        int n = Integer.parseInt(br.readLine());  // tc 개수

        // 2. i만큼 * 찍기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++){
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}