import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String A = br.readLine();
            if (A == null) break;
            String B = br.readLine();

            int[] cntA = getCnt(A);
            int[] cntB = getCnt(B);

            for (int i = 0; i < cntA.length; i++) {
                for (int j = 0; j < Math.min(cntA[i], cntB[i]); j++) {
                    sb.append((char) ('a'+ i));
                }
            }
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static int[] getCnt(String str) {
        int[] tmp = new int[26];
        for (int i = 0; i < str.length(); i++) {
            tmp[str.charAt(i) - 'a']++;
        }
        return tmp;
    }
}