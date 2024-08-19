import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    private static int N, M, L, K;
    private static List<Point> points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        points = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        //2. 완전탐색
        //두 별똥별이 가로지르는 점에서 시작
        int rlt = 0;
        for (int i = 0; i < K; i++) {
            int x = points.get(i).x;

            for (int j = 0; j < K; j++) {
                int y = points.get(j).y;

                int cnt = 0;
                for (int k = 0; k < K; k++) {
                    int kx = points.get(k).x;
                    int ky = points.get(k).y;

                    if (x <= kx && kx <= x + L) {
                        if (y <= ky && ky <= y + L) cnt++;
                    }
                }
                rlt = Math.max(rlt, cnt);
            }
        }
        System.out.println(K - rlt);
    }
}