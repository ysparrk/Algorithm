import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int a = N;
            int b = M;
            int tmp = 0;
            while (b != 0) {
                tmp = b;
                b = a % b;
                a = tmp;
            }

            int lcm = M * N / a;
            int result = -1;

            for (int i = x-1; i < lcm + 1; i += M) {
                if (i % N == y-1) {
                    result = i;
                    break;
                }
            }
            sb.append(result+1 !=0 ? result+1 : -1).append('\n');
        }
        System.out.println(sb);

    }
}