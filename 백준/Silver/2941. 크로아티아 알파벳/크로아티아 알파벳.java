import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String str;
    private static String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        for (int i = 0; i < croatia.length; i++) {
            if (str.contains(croatia[i])) {
                str = str.replace(croatia[i], "0");
            }
        }
        System.out.println(str.length());
    }
}