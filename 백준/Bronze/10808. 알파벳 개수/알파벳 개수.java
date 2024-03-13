import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];

        String S = br.readLine();
        for (int i = 0; i < S.length(); i++) {
            int idx = S.charAt(i) - 97;

            arr[idx]++;
        }


        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}