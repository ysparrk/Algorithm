import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //1. input
        String strN = br.readLine();

        int lenN = strN.length();  //자리수

        int N = Integer.parseInt(strN);
        int rlt = 0;

        //2. 브루트포스 가능한 최솟값인 N - (자리수*9)부터 시작 
        for (int i = N - (lenN * 9); i < N; i++) {
            int num = i;
            int sum = 0;
            
            //1) 자리수 더하기
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            //2) 생성자인 경우
            if (i + sum == N) {
                rlt = i;
                break;
            }
        }

        System.out.println(rlt);

    }
}