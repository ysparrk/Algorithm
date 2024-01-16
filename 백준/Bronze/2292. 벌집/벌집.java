import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int rlt = 1;  //결과
        int cur = 2;  //현재 벌집 번호

        if (N == 1) {
            System.out.println(1);
        } else {
            while (cur <= N) {
                cur += (rlt * 6);
                rlt++;
            }
            System.out.println(rlt);
        }
    }
}