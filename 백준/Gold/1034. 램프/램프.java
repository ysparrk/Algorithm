import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, K;
    private static int[] rampOff; //행의 몇개의 램프가 꺼져있는지
    private static String[] ramp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rampOff = new int[N];
        ramp = new String[N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            int cnt = 0; //꺼져있는 램프 수
            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == '0') {
                    cnt++;
                }
            }
            rampOff[i] = cnt;
            ramp[i] = row;
        }

        K = Integer.parseInt(br.readLine());

        //각 행이 켜질 경우 켜져있는 행의 수 구하기
        int rlt = 0;  //최댓값
        for (int i = 0; i < N; i++) {
            //1) 스위치를 누르는 횟수가 K보다 크면 안됨
            //2) 스위치를 누르는 횟수가 K보다 작다면 남은 횟수는 짝수
            int tmp = 1;  //i행이 켜질 경우 켜져있는 행의 수
            if (rampOff[i] <= K && (K - rampOff[i]) % 2 == 0) {
                //이 경우에 해당 행이 켜짐
                for (int j = 0; j < N; j++) {
                    if (i != j && ramp[i].equals(ramp[j])) {
                        tmp++;
                    }
                }

                rlt = Math.max(rlt, tmp);
            }
        }
        System.out.println(rlt);
    }
}