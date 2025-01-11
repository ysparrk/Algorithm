import java.io.*;
import java.util.*;

public class Main {

    private static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            Integer box[] = new Integer[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                box[i] = a * b;
            }

            Arrays.sort(box, Comparator.reverseOrder());
            int rlt = 0;

            for (int j = 0; j < box.length; j++) {
                J -= box[j];
                rlt++;

                if (J <= 0) {
                    break;
                }
            }
            System.out.println(rlt);
        }
    }
}