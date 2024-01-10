import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 알파벳 배열 선언
        int[] arr = new int[26];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        // 2. input
        String S = br.readLine();

        // 3. 배열 변경
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (arr[ch - 'a'] == -1) {
                arr[ch - 'a'] = i;
            }
        }

        // 4. result -> 배열 출력
        for (int val : arr) {
            System.out.print(val + " ");
        }

    }
}