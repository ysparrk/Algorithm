import java.io.*;
import java.util.Stack;

public class Main {

    public static Stack<Integer> stack = new Stack<>();
    public static int N;
    public static int num = 1;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            
            if (!checkPop(value)) {
                sb = new StringBuilder();
                sb.append("NO");
            }
        }

        System.out.println(sb);
    }


    public static boolean checkPop(int value) {

        //수열에 value를 나열할 때까지 pop이 일어나야 함
        while (num <= N+1) {

            //1) 스택이 비어있으면 푸쉬
            if (stack.empty()) {
                stack.push(num);
                num++;
                sb.append("+").append('\n');
            }
            else {
                //2) 비어있지 않으면
                if (stack.peek() == value) {
                    //value랑 같으면
                    stack.pop();
                    sb.append("-").append('\n');
                    return true;
                } else {
                    //아니면 푸쉬
                    stack.push(num);
                    num++;
                    sb.append("+").append('\n');
                }
            }
        }
        return false;
    }
}