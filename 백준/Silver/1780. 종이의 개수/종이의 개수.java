import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, a, b, c;
    private static int[][] paper;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2.
        devideNine(0, 0, N);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    //9개로 나누기
    private static void devideNine(int row, int col, int size) {
        if (checkNum(row, col, size)) {
            //같은 숫자인 경우
            int n = paper[row][col];

            if (n == -1) {
                a++;
            } else if (n == 0) {
                b++;
            } else {
                c++;
            }
            return;
        }

        //작아진 사이즈로 확인 및 나누기
        int s = size / 3;

        devideNine(row, col, s);
        devideNine(row, col + s, s);
        devideNine(row, col + 2 * s, s);

        devideNine(row + s, col, s);
        devideNine(row + s, col + s, s);
        devideNine(row + s, col + 2 * s, s);

        devideNine(row + 2 * s, col, s);
        devideNine(row + 2 * s, col + s, s);
        devideNine(row + 2 * s, col + 2 * s, s);
    }

    //모두 같은 수로 이루어졌는지 확인
    private static boolean checkNum(int row, int col, int size) {
        int n = paper[row][col]; //시작점의 색상

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (n != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}