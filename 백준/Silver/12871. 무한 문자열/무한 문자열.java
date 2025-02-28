import java.io.*;

public class Main {
    private static String s, t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        t = br.readLine();

        StringBuilder sStr = new StringBuilder(s);
        StringBuilder tStr = new StringBuilder(t);

        int sLen = s.length();
        int tLen = t.length();

        int lcm = (sLen * tLen) / gcd(Math.max(sLen, tLen), Math.min(sLen, tLen));

        for (int i = 0; i < lcm / sLen - 1; i++) {
            sStr.append(s);
        }

        for (int i = 0; i < lcm / tLen - 1; i++) {
            tStr.append(t);
        }

        int rlt = (sStr.toString().equals(tStr.toString())) ? 1 : 0;
        System.out.println(rlt);
    }

    private static int gcd(int max, int min) {
        int tmp;
        while (min != 0) {
            tmp = max % min;
            max = min;
            min = tmp;
        }
        return max;
    }
}