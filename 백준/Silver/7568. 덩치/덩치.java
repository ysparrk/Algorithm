import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //1. input
        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        //2. result
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N; j++) {
                if (info[i][0] < info[j][0] && info[i][1] < info[j][1]) {
                    cnt++;
                }
            }
            sb.append(cnt).append(' ');

        }
        System.out.println(sb);
    }
}