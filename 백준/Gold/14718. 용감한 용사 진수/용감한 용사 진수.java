import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] stat = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stat[i][0] = Integer.parseInt(st.nextToken());
            stat[i][1] = Integer.parseInt(st.nextToken());
            stat[i][2] = Integer.parseInt(st.nextToken());
        }

        //2. 완전탐색
        int rlt = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    //i, j, k용사의 스탯을 사용할 때
                    int tmpSum = stat[i][0] + stat[j][1] + stat[k][2];
                    
                    //1) 합 확인
                    if (tmpSum > rlt) continue;
                        
                    //2) s번째 용사를 추가시킬 수 있는지 확인
                    int cnt = 0;
                    for (int s = 0; s < N; s++) {
                        if (stat[i][0] >= stat[s][0] && stat[j][1] >= stat[s][1] && stat[k][2] >= stat[s][2]) cnt++;
                    }
                    //3) 갱신
                    if (cnt >= K) rlt = tmpSum;
                }
            }
        }
        System.out.println(rlt);
    }
}