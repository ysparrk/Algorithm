import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] alpha = new int[26];
        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'A';
            alpha[idx]++;
        }

        int odd = 0;
        int num = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 != 0) {
                odd++;
                num = i;
            }

            if (odd >= 2) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alpha.length; i++) {
            for (int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        String rlt = sb.toString();

        if (odd == 1) {
            rlt += (char) (num + 'A');
        }
        rlt += sb.reverse().toString();
        System.out.println(rlt);
    }
}