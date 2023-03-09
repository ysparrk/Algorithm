import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. input
        // 공백 있는 숫자열 input
        String[] str = br.readLine().split(" ");
        int H = Integer.parseInt(str[0]); // 현재 시
        int M = Integer.parseInt(str[1]); // 현재 분
        // 다음 줄 읽기
        int C = Integer.parseInt(br.readLine()); // 필요 시간

        // 2. 계산
        if ((M + C) < 60) {
            bw.write(H + " " + (M + C));
        }
        else {
            H = H + (M + C) / 60;
            M = (M + C) % 60;
            if (H >= 24) {
                H = H % 24;  // 24이상이면 0부터 다시 시작
                bw.write(H + " " + M);
            }
            else {
                bw.write(H + " " + M);
            }
        }

        bw.flush();
        bw.close();
    }
}