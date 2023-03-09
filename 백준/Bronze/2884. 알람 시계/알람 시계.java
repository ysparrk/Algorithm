import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 공백 있는 숫자열 input
        String[] str = br.readLine().split(" ");
        int H = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        if (M >= 45) {
            bw.write(H + " " + (M - 45));
        }
        else if (H == 0) {
            bw.write(23 + " " + (60 + M - 45));
        } else {
            bw.write((H - 1) + " " + (60 + M - 45));
        }

        bw.flush();
        bw.close();
    }
}
