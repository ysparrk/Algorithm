import java.io.*;

public class Main {

    private static long S;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Long.parseLong(br.readLine());

        long n = 1;
        long sum = 0;
        int cnt = 0;
        while (true) {
            sum += n;
            cnt++;

            if (sum > S) {
                cnt--;
                break;
            }
            n++;
        }
        System.out.println(cnt);
    }
}