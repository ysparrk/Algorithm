import java.io.*;
import java.util.*;

public class Main {

    private static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int N = str.length();
        List<String> rlt = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                rlt.add(makeStr(i, j));
            }
        }
        
        Collections.sort(rlt);
        System.out.println(rlt.get(0));
    }

    private static String makeStr(int a, int b) {
        StringBuilder s1 = new StringBuilder(str.substring(0, a));
        StringBuilder s2 = new StringBuilder(str.substring(a, b));
        StringBuilder s3 = new StringBuilder(str.substring(b));
        
        StringBuilder sb = new StringBuilder();
        sb.append(s1.reverse()).append(s2.reverse()).append(s3.reverse());
        return sb.toString();
    }
}