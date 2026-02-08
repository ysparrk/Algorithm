import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, T;
    private static int[][] lr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());  //총량

        lr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lr[i][0] = Integer.parseInt(st.nextToken());
            lr[i][1] = Integer.parseInt(st.nextToken());
        }

        //2. 이진탐색
        int S = Integer.MAX_VALUE;
        int start = 0;
        int end = 999999;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(isPossible(mid) == 0) {
                end = mid - 1;
                S = Math.min(S, mid);
            } else if(isPossible(mid) > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (S == Integer.MAX_VALUE) {
            S = -1;
        }
        System.out.println(S);
    }

    private static int isPossible(int num) {
        int minDrink = 0;
        int maxDrintk = 0;
        for(int i=0; i<N; ++i) {
            if(lr[i][0] > num) {
                return 1;  //S+
            }

            minDrink += lr[i][0];
            maxDrintk += Math.min(num, lr[i][1]);
        }

        if(minDrink <= T && maxDrintk >= T) {
            return 0;  //통과
        } else if (minDrink > T) {
            return -1; //S-
        } else {
            return 1;  //S+
        }
    }
}
