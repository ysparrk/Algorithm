import java.io.*;
import java.util.*;

class LectureRequest implements Comparable<LectureRequest>{
    int P;  //pay
    int D;  //day

    public LectureRequest(int P, int D) {
        this.P = P;
        this.D = D;
    }

    @Override
    public int compareTo(LectureRequest l) {
        // 1) pay에 내림차순  2)pay가 같을 때 date 내림차순

        if (this.P == l.P) return l.D - this.D;
        return l.P - this.P;
    }
}


public class Main {

    private static int N;
    private static PriorityQueue<LectureRequest> pq;
    private static boolean[] visited;
    private static int maxDate = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            maxDate = Math.max(maxDate, d);

            pq.add(new LectureRequest(p, d));
        }



        // 2. result
        int rlt = 0;
        visited = new boolean[maxDate + 1];
        while (!pq.isEmpty()) {
            LectureRequest lecture = pq.poll();

            // 강연 가능한지 탐색
            for (int i = lecture.D; i > 0; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    rlt += lecture.P;
                    break;
                }
            }
        }
        System.out.println(rlt);
    }
}