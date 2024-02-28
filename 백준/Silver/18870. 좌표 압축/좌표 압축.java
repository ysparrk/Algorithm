import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. input
        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];  //정렬 X
        int[] sorted = new int[N];  //정렬 할 배열

        
        //2. 정렬
        HashMap<Integer, Integer> rankingMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        
        //3. 각 요소의 랭크 구하기
        int rank = 0;

        for (int s : sorted) {
            if (!rankingMap.containsKey(s)) {
                rankingMap.put(s, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key : origin) {
            int ranking = rankingMap.get(key);
            sb.append(ranking).append(' ');
        }

        System.out.println(sb);
    }
}