import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringTokenizer st1 = new StringTokenizer(str, "0");
        StringTokenizer st0 = new StringTokenizer(str, "1");

        int rlt = Math.min(st1.countTokens(), st0.countTokens());

        System.out.println(rlt);
    }
}