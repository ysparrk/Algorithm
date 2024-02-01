import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] queue;
    public static int first = 0;
    public static int last = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        queue = new int[N];  //queue 크기 지정

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "front":
                    sb.append(front()).append('\n');
                    break;

                case "back":
                    sb.append(back()).append('\n');
                    break;
            }

        }
        System.out.println(sb);
    }

    public static void push(int num) {
        queue[last] = num;
        last++;
    }

    public static int pop() {
        if (last - first == 0) {
            return -1;
        }
        else {
            int res = queue[first];
            queue[first] = 0;
            first++;
            return res;
        }
    }

    public static int size() {
        return last - first;
    }

    public static int empty() {
        if (last - first == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int front() {
        if (last - first == 0) {
            return -1;
        } else {
            return queue[first];
        }
    }

    public static int back() {
        if (last - first == 0) {
            return -1;
        } else {
            return queue[last-1];
        }
    }
}