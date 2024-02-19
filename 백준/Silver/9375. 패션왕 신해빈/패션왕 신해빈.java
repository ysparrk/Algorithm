import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //1. input
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            
            //2. HashMap
            HashMap<String, Integer> clothes = new HashMap<>();

            int N = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                st.nextToken();

                String type = st.nextToken();

                //해시맵에 type이 있을 경우, 종류 개수 +1
                if (clothes.containsKey(type)) {
                    clothes.put(type, clothes.get(type) + 1);
                } else {
                    clothes.put(type, 1);
                }
            }
            
            //3. result
            int rlt = 1;

            for (int val : clothes.values()) {
                rlt *= (val + 1);
            }

            sb.append(rlt - 1).append('\n');
        }
        System.out.println(sb);
    }
}