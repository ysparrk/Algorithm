import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;  //학생 수, 색상 수
    private static int[] stones;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        stones = new int[M];

        int s = 1;
        int e = 0;  //최대 보석 개수

        for (int i = 0; i < M; i++) {
            stones[i] = Integer.parseInt(br.readLine());
            e = Math.max(e, stones[i]);
        }

        //2. BinarySearch
        int rlt = e;
        while (s <= e) {
            int mid = (s + e) / 2;  //mid개의 보석을 나눠준다
            int tmpSum = 0;

            for (int i = 0; i < M; i++) {
                if (stones[i] % mid == 0) {
                    tmpSum += stones[i] / mid;
                } else {
                    tmpSum += stones[i] / mid + 1;  //나눠떨어지지 않으면 한명 더 추가
                }
            }

            //갱신
            if (tmpSum > N) {
                s = mid + 1;
            } else {
                e = mid - 1;
                rlt = mid;
            }
        }
        System.out.println(rlt);
    }
}