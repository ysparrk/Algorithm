import java.io.*;
import java.util.*;

class Candidate implements Comparable<Candidate>{
    int idx;  //후보자 번호
    int stat;

    public Candidate(int idx, int stat) {
        this.idx = idx;
        this.stat = stat;
    }

    @Override
    public int compareTo(Candidate candidate) {
        return candidate.stat - this.stat;
    }
}

public class Main {

    private static int N, maxSum;
    private static boolean[] visited;
    private static Candidate[][] candidates;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        candidates = new Candidate[5][N];
        maxSum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                candidates[j][i] = new Candidate(i, Integer.parseInt(st.nextToken()));
            }
        }

        //정렬
        for (int i = 0; i < 5; i++) {
            Arrays.sort(candidates[i]);
        }

        //2. 백트래킹
        recur(0, 0);
        System.out.println(maxSum);
    }

    private static void recur(int depth, int sum) {
        //종료조건
        if (depth == 5) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < 5; i++) {
            Candidate candi = candidates[depth][i];
            if (visited[candi.idx]) continue;
            visited[candi.idx] = true;
            recur(depth + 1, sum + candi.stat);
            visited[candi.idx] = false;
        }
    }
}