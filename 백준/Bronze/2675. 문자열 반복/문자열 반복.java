import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder rlt = new StringBuilder();  // 문자열 더하기

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            String[] str = br.readLine().split(" ");

            int R = Integer.parseInt(str[0]);
            String S = str[1];

            for (int j = 0; j < S.length(); j++) {
                for (int k = 0; k < R; k++) {
                    rlt.append(S.charAt(j));
                }
            }
            rlt.append('\n');
        }
        System.out.print(rlt);
    }

}