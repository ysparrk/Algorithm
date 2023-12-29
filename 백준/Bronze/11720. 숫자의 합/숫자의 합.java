import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int rlt = 0;

        for (byte value : br.readLine().getBytes()) {
            rlt += (value - '0');
        }

        System.out.print(rlt);

    }
}