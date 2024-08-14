import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());

       //완전탐색
       int cnt = 0;
       for (int b = 1; b <= 500; b++) {
           for (int a = b; a <= 500; a++) {
               if (Math.pow(a, 2) == Math.pow(b, 2) + N) {
                   cnt++;
               }
           }
       }
        System.out.println(cnt);
    }
}