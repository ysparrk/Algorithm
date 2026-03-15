import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    private static int N, K;
    private static int[] shuffled, origin, tmp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        shuffled = new int[N];
        origin = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            shuffled[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i++){
            origin[i] = Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j < K; j++){
            for(int i = 0; i < N; i++){
                tmp[origin[i] - 1] = shuffled[i];
            }
            shuffled = Arrays.copyOf(tmp, tmp.length);
        }

        for(int i = 0; i< N; i++){
            System.out.print(tmp[i] + " ");
        }
    }
}