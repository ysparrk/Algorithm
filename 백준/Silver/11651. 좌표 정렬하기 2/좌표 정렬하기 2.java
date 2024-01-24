import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        
        //1. input
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        //2. sort
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] n1, int[] n2) {
                if (n1[1] == n2[1]) {
                    return n1[0] - n2[0];
                } else {
                    return n1[1] - n2[1];
                }
            }
        });

        //3. result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}