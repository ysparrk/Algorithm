import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R1, C1, R2, C2, find_min;
    static int[][] P1, P2_0, P2_90, P2_180, P2_270;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        //1) 첫번째 퍼즐
        R1 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());

        P1 = new int[R1][C1];
        for (int i = 0; i < R1; i++) {
            String str = br.readLine();
            for (int j = 0; j < C1; j++) {
                P1[i][j] = str.charAt(j) - '0';
            }
        }

        //2) 두번째 퍼즐 -> 4가지 형태로 만들기
        st = new StringTokenizer(br.readLine());

        R2 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        P2_0 = new int[R2][C2];
        P2_90 = new int[C2][R2];
        P2_180 = new int[R2][C2];
        P2_270 = new int[C2][R2];

        for (int i = 0; i < R2; i++) {
            String str = br.readLine();
            for (int j = 0; j < C2; j++) {
                P2_0[i][j] = str.charAt(j) - '0';  //0도
                P2_90[j][R2-1-i] = P2_0[i][j];     //90도 -> 0도에서 x, y 변경
                P2_180[R2-i-1][C2-j-1] = P2_0[i][j];  //180도
                P2_270[C2-j-1][i] = P2_0[i][j];  //270도 -> 180도에서 x, y 변경
            }
        }

        //2. P1의 모든 지점에서 확인
        find_min = Integer.MAX_VALUE;
        for (int i = 0; i < R1; i++) {
            for (int j = 0; j < C1; j++) {
                //i, j에서 브루트포스 시작
                if (check_0_180(i, j, P2_0)) {
                    get_size_0_180(i, j);
                }
                if (check_0_180(i, j, P2_180)) {
                    get_size_0_180(i, j);
                }

                if (check_90_270(i, j, P2_90)) {
                    get_size_90_270(i, j);
                }

                if (check_90_270(i, j, P2_270)) {
                    get_size_90_270(i, j);
                }
            }
        }
        System.out.println(find_min);
    }

    //3.
    //1) 0도, 180도의 퍼즐 확인
    public static boolean check_0_180(int x, int y, int[][] puzzle) {
        for (int i = x; i < R1; i++) {
            for (int j = y; j < C1; j++) {
                //puzzle 범위 확인
                if (i - x < R2 && j - y < C2) {
                    if (P1[i][j] == 1 && puzzle[i - x][j - y] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //2) 90도, 270도 퍼즐 확인
    public static boolean check_90_270(int x, int y, int[][] puzzle) {
        for (int i = x; i < R1; i++) {
            for (int j = y; j < C1; j++) {
                if (i - x < C2 && j - y < R2) {
                    if (P1[i][j] == 1 && puzzle[i - x][j - y] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //4. 액자가 가능한 경우 -> 최소 사이즈 구하기
    //1) 0도, 180도의 퍼즐 확인
    public static void get_size_0_180(int x, int y) {
        int a = Math.max(R1, x + R2);
        int b = Math.max(C1, y + C2);
        find_min = Math.min(find_min, a * b);
    }

    //2) 90도, 270도 퍼즐 확인
    public static void get_size_90_270(int x, int y) {
        int a = Math.max(R1, x + C2);
        int b = Math.max(C1, y + R2);
        find_min = Math.min(find_min, a * b);
    }
}