import java.io.*;


public class Main {

    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        recur(0, "");
    }

    private static void recur(int depth, String str) {
        if (depth == N) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            //다음 수열이 좋은 수열이면 움직이기
            if (check(str + i)) recur(depth + 1, str + i);
        }

    }

    private static boolean check(String tmpStr) {
        //길이 1부터 시작해서 전체 문자열의 길이의 절반만 확인
        int len = tmpStr.length();

        for (int i = 1; i <= len / 2; i++) {
            String front = tmpStr.substring(len - i * 2, len - i);
            String back = tmpStr.substring(len - i, len);

            if (front.equals(back)) return false;
        }
        return true;
    }
}