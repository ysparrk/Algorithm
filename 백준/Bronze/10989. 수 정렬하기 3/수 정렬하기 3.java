/**
 * 카운팅 정렬
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[10001]; //수의 범위

        int N = Integer.parseInt(br.readLine());

        //1. 해당 인덱스의 값 1 증가
        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        
        //2. 
        for (int i = 1; i < 10001; i++) {
            //해당 인덱스 다 담기
            while (cnt[i] > 0) {
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }
        System.out.println(sb);
        
    }
}