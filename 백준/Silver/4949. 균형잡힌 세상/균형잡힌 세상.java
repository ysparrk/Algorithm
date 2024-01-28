import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        //1. input
        while (true) {
            str = br.readLine();

            if (str.equals(".")) {
                break;
            }

            sb.append(check(str)).append('\n');
        }

        System.out.println(sb);
    }
    
    //2. Stack 활용
    public static String check(String str) {
        Stack<Character> stackChar = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);


            if (c == '(' || c == '[') {
                stackChar.push(c);
            }
            else if (c == ')') {
                if (stackChar.empty() || stackChar.peek() != '(') {
                    return "no";
                } else {
                    stackChar.pop();
                }
            }
            else if (c == ']') {
                if (stackChar.empty() || stackChar.peek() != '[') {
                    return "no";
                } else {
                    stackChar.pop();
                }
            }
        }
        //stack 비었는지 확인
        if (stackChar.empty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}