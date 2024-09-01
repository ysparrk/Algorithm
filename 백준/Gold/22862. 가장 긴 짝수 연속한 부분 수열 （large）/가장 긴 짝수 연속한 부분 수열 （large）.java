import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            nums[i] = n % 2;
        }
        nums[N] = 1;

        //2. 투포인터
        int s = 0;
        int e = 0;

        //1) 시작점 찾기
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (nums[i] == 0) {
                s = i;
                e = i;
                flag = true;
                break;
            }
        }
        //짝수가 존재하지 않는 경우
        if (!flag) {
            System.out.println(0);
            return;
        }

        int rlt = 1;
        int len = 1;
        int del = 0;
        while (e < N) {
            switch (nums[e + 1]) {
                case 0:
                    len++;
                    e++;
                    break;
                case 1:
                    //삭제 가능 확인
                    if (del < K) {
                        nums[++e] = -1;
                        del++;
                    } else {
                        if (nums[s] == -1) del--;
                        else if (nums[s] == 0) len--;
                        s++;
                    }
                    break;
            }
            rlt = Math.max(rlt, len);
        }
        System.out.println(rlt);
    }
}