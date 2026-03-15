import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, A, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int[] value = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxStack = 0;
        for (int i = 0; i < N; i++) {
            if (value[i] != A) {
                continue;
            }
            maxStack++;
            A += D;
        }

        System.out.println(maxStack);
    }
}