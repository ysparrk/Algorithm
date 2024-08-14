import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int score = 0;
        for (int i = 0; i < 10; i++) {
            int mushroom = Integer.parseInt(br.readLine());

            score += mushroom;

            if (score >= 100) {
                if (score - 100 > 100 - (score - mushroom)) {
                    score -= mushroom;
                }
                break;
            }
        }
        System.out.println(score);
    }
}