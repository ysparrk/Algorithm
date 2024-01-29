import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < K; i++) {
            int now = Integer.parseInt(br.readLine());

            if (now != 0) {
                stack.push(now);
                sum += now;
            } 
            else {
                int temp = stack.pop();
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}