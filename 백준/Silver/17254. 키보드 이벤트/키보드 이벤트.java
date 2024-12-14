import java.io.*;
import java.util.*;

class key {
    int a;
    int b;
    String c;

    public key(int a, int b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {
    private static int N, M;
    private static List<key> keys;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        keys = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String c = st.nextToken();

            keys.add(new key(a, b, c));
        }

        //2. 정렬
        Collections.sort(keys, new Comparator<key>() {
            @Override
            public int compare(key o1, key o2) {
                if (o1.b == o2.b) {
                    return Integer.compare(o1.a, o2.a);
                }

                return Integer.compare(o1.b, o2.b);
            }
        });

        //3. result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(keys.get(i).c);
        }

        System.out.println(sb);
    }
}