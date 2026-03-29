import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            Stack<Character> pwd = new Stack<>();
            Stack<Character> delete = new Stack<>();
            int cursor = 0;
            for(int j=0; j<line.length(); j++) {
                char pos = line.charAt(j);
                if(pos == '<') {
                    if(!pwd.isEmpty()) {
                        delete.push(pwd.pop());
                    }
                }else if(pos == '>') {
                    if(!delete.isEmpty()) {
                        pwd.push(delete.pop());
                    }
                }else if(pos == '-') {
                    if(!pwd.isEmpty()) {
                        pwd.pop();
                    }
                }else {
                    pwd.push(line.charAt(j));
                }
            }

            while(!delete.isEmpty()) {
                pwd.push(delete.pop());
            }

            for (int k = 0; k < pwd.size(); k++) {
                sb.append(pwd.get(k));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}