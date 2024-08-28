import java.io.*;

public class Main {

    private static int G;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. input
        G = Integer.parseInt(br.readLine());

        //2. 투포인터
        //s와 e의 차이가 G인 것 찾기
        boolean flag = false;
        long s = 1;
        long e = 2;

        while (s < e && e <= 100_000) {
            long tmp = e * e - s * s;

            if (tmp == G) {
                System.out.println(e);
                flag = true;
                s++;
                e++;
            } else if (tmp > G) {
                s++;
            } else {
                e++;
            }
        }

        if (!flag) System.out.println(-1);
    }
}