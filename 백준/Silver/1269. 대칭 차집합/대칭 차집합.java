import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    
    private static int A;
    private static int B;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        HashSet<Integer> Elements = new HashSet<Integer>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < A; i++) {
            Elements.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B; i++) {
            Elements.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println((Elements.size() - B) + (Elements.size() - A));

    }
}
