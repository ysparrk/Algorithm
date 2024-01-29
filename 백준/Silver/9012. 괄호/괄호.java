import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. input
        int T = Integer.parseInt(br.readLine());

        String str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            str = br.readLine();

            sb.append(check(str)).append('\n');

        }

        System.out.println(sb);
    }

    //2. 괄호 확인
    public static String check(String str) {

        Stack<Character> stackChar = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char now = str.charAt(i);

            if (now == '(') {
                stackChar.push(now);
            } else if (now == ')' && !stackChar.empty() && stackChar.peek() == '(') {
                stackChar.pop();
            } else {
                return "NO";
            }
        }

        //스택 확인
        if (stackChar.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}