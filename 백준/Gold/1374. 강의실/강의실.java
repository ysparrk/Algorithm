import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture> {
    int lectureNum;
    int start;
    int end;

    public Lecture(int lectureNum, int start, int end) {
        this.lectureNum = lectureNum;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture o) {
        //시작 시간이 빠른 순, 종료 시간이 빠른 순으로 정렬
        if (this.start == o.start) return this.end - o.end;
        else return this.start - o.start;
    }
}

public class Main {
    /*
    필요한 최소 강의실 개수
     */
    private static int N;
    private static PriorityQueue<Lecture> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int lectureNum = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Lecture(lectureNum, start, end));
        }

        //각 강의실을 몇시까지 사용하는지
        PriorityQueue<Integer> classRoom = new PriorityQueue<>();
        classRoom.add(0);

        while (!pq.isEmpty()) {
            Lecture cur = pq.poll();
            int minTime = classRoom.peek();

            if (cur.start < minTime) classRoom.add(cur.end);
            else {
                //연장 가능
                classRoom.poll();
                classRoom.add(cur.end);
            }
        }
        System.out.println(classRoom.size());
    }
}