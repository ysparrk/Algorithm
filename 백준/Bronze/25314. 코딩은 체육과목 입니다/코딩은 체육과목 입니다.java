import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. input
        int n = Integer.parseInt(br.readLine());

        // 2. for문 0으로 시작해서 4로 나눈 몫까지 long 출력
        for (int i = 0; i < n / 4; i++) {
            bw.write("long" + " ");
        }
        bw.write("int");
        bw.flush();
        bw.close();
    }
}