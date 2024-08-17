import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            long S = Long.parseLong(br.readLine());

            for (int i = 2; i <= 1000000; i++) {
                if (S % i == 0) {
                    System.out.println("NO");
                    break;
                }
                if (i == 1000000) System.out.println("YES");
            }
        }
    }
}