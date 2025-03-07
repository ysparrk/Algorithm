import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, rlt;
    private static int unit = Integer.MAX_VALUE;
    private static int pack = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            unit = Math.min(unit, Integer.parseInt(st.nextToken()));
        }

        if (unit * 6 <= pack) {
            rlt = unit * N;
        }
        else {
            rlt = (N / 6) * pack;
            
            if (N % 6 * unit <= pack) {
                rlt += (N % 6) * unit;
            }
            else {
                rlt += pack;
            }
        }
        System.out.println(rlt);
    }
}
