import java.io.*;

public class Main {

    private static int N, targetSize;
    private static String target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] wordsInit = new int[26];
        target = br.readLine();
        targetSize = target.length();

        for (int i = 0; i < targetSize; i++) {
            wordsInit[target.charAt(i) - 'A']++;
        }

        int rlt = 0;
        for (int i = 0; i < N - 1; i++) {
            String str = br.readLine();
            if(isSimilar(str, wordsInit)) rlt++;
        }
        System.out.println(rlt);
    }

    private static boolean isSimilar(String str, int[] wordsInit) {
        int[] words = wordsInit.clone();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            //같은 알파벳인 경우
            if (words[str.charAt(i) - 'A'] > 0) {
                words[str.charAt(i) - 'A']--;
                cnt++;
            }
        }
        // 같은 구성 or 한 글자 변경
        if (targetSize == str.length() && (targetSize == cnt || targetSize - 1 == cnt)) {
            return true;
        }
        // 짧은 경우(제거)
        else if (targetSize == str.length() - 1 && str.length() - 1 == cnt) {
            return true;
        }
        // 긴 경우(제거)
        else if (targetSize == str.length() + 1 && str.length() == cnt) {
            return true;
        }
        return false;
    }
}