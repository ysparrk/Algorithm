import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<String> arr = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr.add(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (arr.contains(br.readLine())) cnt++;
        }
        System.out.println(cnt);
    }
}