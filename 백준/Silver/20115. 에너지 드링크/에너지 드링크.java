import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static double[] drinks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        drinks = new double[N];

        double max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            drinks[i] = Double.parseDouble(st.nextToken());
            max = Math.max(max, drinks[i]);
        }

        double sum = max;
        for (int i = 0; i < N; i++) {
            if (drinks[i] == max) continue;
            sum += drinks[i] / 2;
        }
        System.out.println(sum);
    }
}