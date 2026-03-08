import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    private static int N;
    private static int M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        int[] map = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = i;
        }
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int tmp = 0;
            for (int j = a; j <= b; j++) { 
                if(map[j] != j) {
                    tmp = map[j];
                }
                if(tmp != 0) {
                    map[j] = tmp;
                } else {
                    map[j] = a;
                }
            }
        }
        
        int rlt = 0;
        for (int i = 1; i <= N; i++) {
            if(map[i] == i) {
                rlt++;
            }
        }
        System.out.println(rlt);
    }
}
