import java.io.*;
import java.util.*;

public class Main {

    private static int N, cntMax, gMin;
    private static int[][] grade;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        grade = new int[6][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a != b) {
                grade[a][i] += grade[a][i - 1] + 1;
                grade[b][i] += grade[b][i - 1] + 1;
            } else {
                grade[a][i] += grade[a][i - 1] + 1;
            }

        }

        //값 구하기
        cntMax = 0;
        gMin = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= N; j++) {
                if (grade[i][j] > cntMax) {
                    cntMax = grade[i][j];
                    gMin = i;
                }
            }
        }
        System.out.println(cntMax + " " + gMin);
    }
}