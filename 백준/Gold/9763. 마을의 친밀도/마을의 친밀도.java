import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];

        int answer = 2000000;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < N; i++) {
            //한 점에서 가장 짧은 간선 2개
            int min1 = 1000000, min2 = 1000000;
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    int d1 = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]) + Math.abs(arr[i][2] - arr[j][2]);

                    if (min1 > d1) {
                        min2 = min1;
                        min1 = d1;
                    } else if (min2 > d1) {
                        min2 = d1;
                    }
                }
                answer = Math.min(min1 + min2, answer);
            }
        }
        System.out.println(answer);
    }
}