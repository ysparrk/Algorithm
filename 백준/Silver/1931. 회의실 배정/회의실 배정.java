import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. input
        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        

        //2. 종료 시간을 기준으로 정렬 + 같으면 시작시간 기준
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });


        /**
         * 3. result
         * 직전 종료 시간이 다음 회의의 시작 시간 보다 작으면 -> cnt++
         */
        int cnt = 0;
        int endTime = 0;

        for (int i = 0; i < N; i++) {
            if (endTime <= time[i][0]) {
                endTime = time[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}