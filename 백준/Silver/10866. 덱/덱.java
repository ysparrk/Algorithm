import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] deque = new int[20001];
    public static int start = 10000;
    public static int last = 10000;
    public static int size = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;

                case "pop_back":
                    sb.append(pop_back()).append('\n');
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

    public static void push_front(int num) {
        deque[start] = num;
        start--;
        size++;
    }

    public static void push_back(int num) {
        last++;
        size++;
        deque[last] = num;
    }

    public static int pop_front() {
        if (size == 0) {
            return -1;
        }
        int res = deque[start + 1];
        start++;
        size--;
        return res;
    }

    public static int pop_back() {
        if (size == 0) {
            return -1;
        }
        int res = deque[last];
        last--;
        size--;
        return res;
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        }
        return 0;
    }

    public static int front() {
        if (size == 0) {
            return -1;
        }
        return deque[start + 1];
    }

    public static int back() {
        if (size == 0) {
            return -1;
        }
        return deque[last];
    }
}