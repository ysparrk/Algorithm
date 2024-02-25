import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        char[] ch = br.readLine().toCharArray();
        int[] memo = new int[M];  //'OI'가 나타나는 개수 memoization
        int cnt = 0;

        for (int i = 1; i < M - 1; i++) {
            if (ch[i] == 'O' && ch[i + 1] == 'I') {
                memo[i + 1] = memo[i - 1] + 1;

                //Pn 만족 + 첫 자리가 I
                if (memo[i + 1] >= N && ch[i - N * 2 + 1] == 'I') {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}