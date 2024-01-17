import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. input
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int M = 1234567891;
        long rlt = 0;
        long pow = 1;


        //2. 모듈러연산
        for (int i = 0; i < L; i++) {
            rlt += (str.charAt(i) - 96) * pow % M;
            pow = (pow * 31) % M;
        }
        System.out.println(rlt % M);


    }
}