import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static int N;
    private static String[] shom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. input
        N = Integer.parseInt(br.readLine());
        shom = new String[N];
        for (int i = 0; i < N; i++) {
            makeShom(br.readLine(), i);
        }

        //2. 쌍인지 확인
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (shom[i].equals(shom[j])) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void makeShom(String word, int idx) {
        StringBuilder shomStr = new StringBuilder();
        Map<Character, Character> map = new HashMap<>();

        char c = 'a';
        for (int i = 0; i < word.length(); i++) {
            if (!map.containsKey(word.charAt(i))) {
                map.put(word.charAt(i), c);
                c++;
            }
            shomStr.append(map.get(word.charAt(i)));
        }
        shom[idx] = shomStr.toString();
    }
}
