import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int temp = 0;

        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(st.nextToken());

            temp += num * num;
        }

        int rlt = temp % 10;
        System.out.println(rlt);

    }
}