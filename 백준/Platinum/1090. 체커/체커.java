import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] xclst, yclst, rlt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());
        xclst = new int[N];
        yclst = new int[N];
        rlt = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            xclst[i] = Integer.parseInt(st.nextToken());
            yclst[i] = Integer.parseInt(st.nextToken());
            rlt[i] = Integer.MAX_VALUE;  //rlt 배열 초기화
        }


        //2. 완전탐색
        for (int x : xclst) {
            for (int y : yclst) {

                int[] dist = new int[N];

                //1) 모이는 점을 (x, y)로 선택 시 모든 체커와의 거리
                for (int k = 0; k < N; k++) {
                    dist[k] = Math.abs(xclst[k] - x) + Math.abs(yclst[k] - y);
                }

                //2) 정렬
                Arrays.sort(dist);

                //3) c개의 체커 -> 최소 횟수 업데이트
                int tmp = 0;
                for (int c = 0; c < N; c++) {
                    tmp += dist[c];
                    rlt[c] = Math.min(rlt[c], tmp);
                }
            }
        }


        // 3. result
        StringBuilder sb = new StringBuilder();
        for (int r : rlt) {
            sb.append(r + " ");
        }
        System.out.println(sb);
    }
}