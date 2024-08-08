import java.io.*;
import java.util.*;

public class Main {

    private static int N, X, Y;
    private static int[] xlst, ylst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());

        xlst = new int[N];
        ylst = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            xlst[i] = Integer.parseInt(st.nextToken());
            ylst[i] = Integer.parseInt(st.nextToken());
        }

        //2. 중점 구하기
        Arrays.sort(xlst);
        Arrays.sort(ylst);

        X = xlst[(N - 1) / 2];
        Y = ylst[(N - 1) / 2];

        //3. result
        long rlt = 0;
        for (int i = 0; i < N; i++) {
            rlt += Math.abs(X - xlst[i]) + Math.abs(Y - ylst[i]);
        }
        System.out.println(rlt);
    }
}