import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int S = Integer.MAX_VALUE;  //시간
        int H = 0;  //높이

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        /**
         * 1. input
         * 1) input
         * 2) min, max 찾기
         */
        int[] mine = new int[N * M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                mine[i * M + j] = value;
                min = Math.min(min, value);
                max = Math.max(max, value);
            }
        }

        /**
         * 2. 브루트포스
         * 1) min ~ max 사이의 높이 탐색
         */
        for (int h = min; h <= max; h++) {

            int seconds = 0;
            int inventory = B;

            for (int i = 0; i < N * M; i++) {
                int temp = mine[i] - h;

                //1) 제거
                if (temp > 0) {
                    seconds += temp * 2;
                    inventory += temp;
                }
                //2) 쌓기
                else if (temp < 0) {
                    seconds += -temp;
                    inventory -= -temp;
                }
            }

            if (seconds <= S && inventory >= 0) {
                S = seconds;
                H = h;  //높은걸로 교체됨
            }
        }
        System.out.println(S + " " + H);
    }
}