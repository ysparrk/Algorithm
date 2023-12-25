import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];
        String str = br.readLine();

        // 1) 알파벳 빈도 arr 생성
        for (int i = 0; i < str.length(); i++) {
            // 대문자
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                arr[str.charAt(i) - 'A']++;
            }
            // 소문자
            else {
                arr[str.charAt(i) - 'a']++;
            }
        }

        // 2) 최빈값 찾기
        int max = -1;
        char ch = '?';
        for (int i = 0; i < 26; i++) {

            if (arr[i] > max) {
                max = arr[i];
                ch = (char) (i+65);  // int -> char 형변환 + 대문자 출력
            } else if (arr[i] == max) {
                ch = '?';
            }
        }
        System.out.print(ch);
    }
}