import java.io.*;
import java.util.*;

public class Main {
    public static Queue<Integer> queue;
    public static Queue<Integer> idxQueue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        //1. input
        while (T--> 0) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());  //문서 개수
            int M = Integer.parseInt(st.nextToken());  //몇번째로 인쇄

            queue = new LinkedList<>();
            idxQueue = new LinkedList<>();


            //1) 중요도, 인덱스 입력
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
                idxQueue.offer(i);
            }

            //2) 문서가 몇번째로 출력되는지
            sb.append(solve(M)).append('\n');
        }
        System.out.println(sb);
    }

    public static int solve(int M) {
        int cnt = 0;

        while (!queue.isEmpty()) {
            int maxValue = Collections.max(queue); //최우선 문서
            int cur = queue.poll();  //현재 문서
            int curIdx = idxQueue.poll();  //현재 문서의 인덱스

            if (cur == maxValue) {
                cnt++;  //순서 더하기

                if (curIdx == M) {
                    return cnt;
                }

            } else {
                //큐에서 제거가 되지 않으면 큐의 뒤에 넣기
                queue.offer(cur);
                idxQueue.offer(curIdx);
            }

        }
        return cnt;
    }
}