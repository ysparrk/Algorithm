import java.io.*;

public class Main {
    private static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        String rlt;

        rlt = poliomino(str);
        System.out.println(rlt);
    }

    private static String poliomino(String s) {
        String tmp;
        String A = "AAAA";
        String B = "BB";

        s = s.replaceAll("XXXX", A);
        tmp = s.replaceAll("XX", B);

        if (tmp.contains("X")) tmp = "-1";
        return tmp;
    }
}