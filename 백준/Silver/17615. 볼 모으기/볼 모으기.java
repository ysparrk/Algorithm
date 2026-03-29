import java.io.*;

public class Main {
    private static int N;
    private static String balls;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        balls = br.readLine();

        int cnt = Integer.MAX_VALUE;

        int subCnt = 0;
        boolean change = false;
        for(int i = 0; i < N; i++) {
            if(change && balls.charAt(i) == 'R') {
                subCnt++;
                continue;
            }

            if(balls.charAt(i) == 'B') change = true;
        }
        cnt = Math.min(cnt, subCnt);

        subCnt = 0;
        change = false;
        for(int i = 0; i < N; i++) {
            if(change && balls.charAt(i) == 'B') {
                subCnt++;
                continue;
            }

            if(balls.charAt(i) == 'R') {
                change = true;
            }
        }
        cnt = Math.min(cnt, subCnt);


        subCnt = 0;
        change = false;
        for(int i = N - 1; i >= 0; i--) {
            if(change && balls.charAt(i) == 'R') {
                subCnt++;
                continue;
            }

            if(balls.charAt(i) == 'B') {
                change = true;
            }
        }
        cnt = Math.min(cnt, subCnt);

        subCnt = 0;
        change = false;
        for(int i = N - 1; i >= 0; i--) {
            if(change && balls.charAt(i) == 'B') {
                subCnt++;
                continue;
            }

            if(balls.charAt(i) == 'R') {
                change = true;
            }
        }

        cnt = Math.min(cnt, subCnt);

        System.out.println(cnt);
    }
}