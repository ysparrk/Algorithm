import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //정렬 순서 n%10 == 0, 짧은 것
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator
                .comparingInt((Integer n) -> n % 10)
                .thenComparingInt(n -> n));

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            //길이가 10인 경우 바로 카운트
            if (n == 10) {
                cnt++;
                continue;
            }
            //못만듬
            if (n < 10) {
                continue;
            }
            pq.add(n);
        }

        while (M > 0 && !pq.isEmpty()) {
            Integer cake = pq.poll();

            if (cake - 10 == 10) {
                cnt++;
            }

            if (cake - 10 > 10) {
                pq.add(cake - 10);
            }
            cnt++;
            M--;
        }
        System.out.println(cnt);
    }
}