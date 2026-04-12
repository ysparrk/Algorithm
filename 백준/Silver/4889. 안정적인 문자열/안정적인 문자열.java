import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int index = 1;

        while (true) {
            String str = bf.readLine();

            if (str.contains("-")) {
                break;
            }

            stk.clear();

            int count = count(stk, str);

            sb.append(index)
                    .append(". ")
                    .append(count)
                    .append("\n");

            index++;
        }

        System.out.println(sb);
    }

    private static int count(Stack<Character> stk, String str) {
        int answer = 0;
        int length = str.length();

        for (int i = 0; i < length; i++) {
            char now = str.charAt(i);

            switch (now) {
                case '{' :
                    stk.push(now);
                    break;
                case '}' :
                    if (stk.isEmpty()) {
                        answer++;
                        stk.push('{');
                    } else {
                        stk.pop();
                    }
                    break;
            }
        }

        int left = stk.size();
        answer += (left / 2);

        return answer;
    }
}