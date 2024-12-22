import java.io.*;
import java.util.*;

public class Main {
    private static int N, H, W;
    private static char ch[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        ch = new char[N];

        Arrays.fill(ch,'?');

        for(int i = 0; i < H; i++){
            String str = br.readLine();
            for(int j = 0; j < N*W; j++){
                char c = str.charAt(j);
                if(c == '?') continue;
                else ch[j / W] = c;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(ch[i]);
        }
        System.out.println(sb);
    }
}