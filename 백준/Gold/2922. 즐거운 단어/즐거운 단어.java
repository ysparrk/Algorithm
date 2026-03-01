import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static char[] word;
    private static int[] type;  //0: 자음, 1: 모음, 2: _, 3: L
    private static int N;

    private static String VOWEL = "AEIOU";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine().toCharArray();
        N = word.length;
        type = new int[N];

        //글자 종류 분리
        for (int i = 0; i < N; i++) {
            if (VOWEL.indexOf(word[i]) != -1) {
                type[i] = 1;
            } else if (word[i] == '_') {
                type[i] = 2;
            } else if (word[i] == 'L') {
                type[i] = 3;
            } else {
                type[i] = 0;
            }
        }
        
        long rlt = recur(0, 0, 0, 0);

        System.out.println(rlt);
    }

    private static long recur(int idx, int vowelCnt, int consCnt, int isL) {
        if (vowelCnt >= 3 || consCnt >= 3) {
            return 0;
        }

        if (idx == N) {
            return isL;
        }

        long rlt = 0;
        if (type[idx] == 2) {
            //밑줄
            rlt += recur(idx + 1, vowelCnt + 1, 0, isL) * 5;
            rlt += recur(idx + 1, 0, consCnt + 1, isL) * 20;
            rlt += recur(idx + 1, 0, consCnt + 1, 1);  // _ -> L
        } else if (type[idx] == 1) {
            //모음
            rlt += recur(idx + 1, vowelCnt + 1, 0, isL);
        } else if (type[idx] == 3) {
            //L 경우
            rlt += recur(idx + 1, 0, consCnt + 1, 1);
        } else {
            rlt += recur(idx + 1, 0, consCnt + 1, isL);
        }

        return rlt;
    }
}
