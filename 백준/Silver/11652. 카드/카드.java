import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> cards = new HashMap<>();

        int max = 0;
        long rlt = 0;
        for (int i = 0; i < N; i++) {
            long card = Long.parseLong(br.readLine());

            cards.put(card, cards.getOrDefault(card, 0) + 1);

            if (cards.get(card) > max) {
                max = cards.get(card);
                rlt = card;
            } else if (cards.get(card) == max) {
                rlt = Math.min(rlt, card);
            }
        }
        System.out.println(rlt);
    }
}