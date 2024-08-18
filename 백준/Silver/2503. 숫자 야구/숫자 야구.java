import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] question;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. input
        N = Integer.parseInt(br.readLine());

        question = new int[N][5];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            question[i][0] = tmp / 100;
            question[i][1] = (tmp % 100) / 10;
            question[i][2] = (tmp % 100) % 10;
            question[i][3] = Integer.parseInt(st.nextToken());
            question[i][4] = Integer.parseInt(st.nextToken());
        }

        //2. 완전탐색
        int cnt = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {

                if (i == j) continue;

                for (int k = 1; k <= 9; k++) {

                    if (i == k || j == k) continue;

                    if (isValid(i, j, k)) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static boolean isValid(int i, int j, int k) {

        // ijk가 조건들을 다 만족하는지 확인
        for (int q = 0; q < N; q++) {

            int strike = 0;
            int ball = 0;

            if (question[q][0] == i) strike++;
            if (question[q][1] == j) strike++;
            if (question[q][2] == k) strike++;
            if (question[q][1] == i || question[q][2] == i) ball++;
            if (question[q][0] == j || question[q][2] == j) ball++;
            if (question[q][0] == k || question[q][1] == k) ball++;

            if (question[q][3] != strike || question[q][4] != ball) return false;
        }
        return true;
    }
}