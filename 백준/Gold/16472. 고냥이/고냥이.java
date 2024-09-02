import java.io.*;

public class Main {

    private static int N;
    private static int[] alphabet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. input
        N = Integer.parseInt(br.readLine());
        alphabet = new int[26];

        String str = br.readLine();

        //2. 투포인터
        int s = 0;
        int e = 0;
        int rlt = 1;
        int cnt = 1;

        alphabet[str.charAt(0) - 97] = 1;

        while (e < str.length() - 1) {
            Character ch = str.charAt(e + 1);

            if (alphabet[ch - 97] > 0) {
                alphabet[ch - 97]++;
                e++;
            } else if (alphabet[ch - 97] == 0 && cnt < N) {
                alphabet[ch - 97]++;
                cnt++;
                e++;
            } else {
                Character del = str.charAt(s);
                alphabet[del - 97]--;
                if (alphabet[del - 97] == 0) {
                    cnt--;
                }
                s++;
            }
            rlt = Math.max(rlt, e - s + 1);
        }
        System.out.println(rlt);
    }
}