import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] rank;
    private static long rlt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        rank = new int[N + 1];
        rank[0] = 0;

        for (int i = 1; i <= N; i++) {
            rank[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rank);

        for (int i = 1; i <= N; i++) {
            rlt += Math.abs(i - rank[i]);
        }

        System.out.println(rlt);
    }
}