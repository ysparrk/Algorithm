import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = 666;
        while (N > 1) {
            num++;
            if (String.valueOf(num).contains("666")) {
                N--;
            }
        }

        System.out.println(num);
    }
}