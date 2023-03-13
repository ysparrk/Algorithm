import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. input
        int n = Integer.parseInt(br.readLine());  // tc 개수

        // 2. n-i만큼 공백, i만큼 * 찍기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                bw.write(" ");
            }
            for (int k = 1; k <= i; k++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}