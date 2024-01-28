import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 4 || N == 7) {
            System.out.println(-1);
            return;
        }

        int mod = N % 5;

        switch (mod) {
            case 0:
                System.out.println(N / 5);
                break;
            case 1:
            case 3:
                System.out.println((N / 5) + 1);
                break;
            case 2:
            case 4:
                System.out.println((N / 5) + 2);
                break;
        }
    }
}