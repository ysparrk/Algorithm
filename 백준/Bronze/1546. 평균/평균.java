import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double scores[] = new double[N];
        double maxNum = 0;
        double sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            sum += scores[i];

            if (scores[i] > maxNum) {
                maxNum = scores[i];
            }

        }

        //3. result
        double rlt = sum * 100 / maxNum / N;
        System.out.println(rlt);
    }
}