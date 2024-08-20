import java.io.*;
import java.util.*;

class Lifeguard {
    int start;
    int end;

    public Lifeguard(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {

    private static int N;
    private static int[] time;
    private static ArrayList<Lifeguard> guard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());
        time = new int[1001];
        guard = new ArrayList<>();

        int totalTime = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            guard.add(new Lifeguard(start, end));

            for (int j = start; j < end; j++) {

                if (time[j] == 0) totalTime++;
                time[j]++;
            }
        }

        //2. 완전탐색
        int rlt = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int cnt = 0;

            for (int j = guard.get(i).start; j < guard.get(i).end; j++) {
                if (time[j] <= 1) {
                    cnt++;
                }
            }
            rlt = Math.min(rlt, cnt);
        }
        System.out.println(totalTime - rlt);
    }
}