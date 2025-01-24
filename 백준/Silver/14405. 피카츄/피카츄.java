import java.io.*;

public class Main {
    private static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        str = str.replaceAll("pi|ka|chu", "");
        if (str.equals("")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}