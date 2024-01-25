import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //1. queue에 삽입
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        //2. StringBuilder 시작
        StringBuilder sb = new StringBuilder();
        sb.append('<');


        //3. queue에서 빼기
        while (q.size() > 1) {
            //K 번째 원소 반환
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            //마지막 원소 반환
            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll()).append('>');
        System.out.println(sb);
    }
}