import java.io.*;
import java.util.*;

public class Main {
 
    private static int N, B, W;
    private static int[] stones;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //1. input
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        stones = new int[N + 1];
        String stone = br.readLine();
        for (int i = 0; i < N; i++) {

            switch (stone.charAt(i)) {
                case 'W':
                    stones[i] = 1;
                    break;
                case 'B':
                    stones[i] = -1;
                    break;
            }
        }

        //2. 투포인터
        int s = 0;
        int e = 0;
        int b = 0;
        int w = 0;
        int rlt = 0;

        //시작점 구별
        if (stones[s] == 1) w++;
        else b++;

        while (e < N) {
            if (b <= B && w >= W) {
                rlt = Math.max(rlt, e - s + 1);
                if (stones[e + 1] == 1) w++;
                else if (stones[e + 1] == -1) b++;
                e++;
            } else if (b > B) {
                if (stones[s] == 1) w--;
                else if (stones[s] == -1) b--;
                s++;
            } else if (w < W) {
                if (stones[e + 1] == 1) w++;
                else if (stones[e + 1] == -1) b++;
                e++;
            }
        }
        System.out.println(rlt);
    }
}