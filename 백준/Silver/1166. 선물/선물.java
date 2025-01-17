import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long L, W, H;
    private static double min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());
        W = Long.parseLong(st.nextToken());
        H = Long.parseLong(st.nextToken());

        min = L;
        min = Math.min(W, Math.min(min, H));

        double l = 0;
        double h = min;
        double mid;

        for(int i = 0; i < 5000; ++i){
            mid = (l + h) / 2;

            if((long)(L / mid) * (long)(W / mid) * (long)(H / mid) < N){
                h = mid;
            }
            else{
                l = mid;
            }
        }
        System.out.print(l);
    }
}