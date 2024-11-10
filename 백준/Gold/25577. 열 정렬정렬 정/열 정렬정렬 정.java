import java.io.*;
import java.util.*;

public class Main {

    private static int N, rlt;
    private static int[] arr, sorted;
    private static Map<Integer, Integer> locate;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        locate = new HashMap<>();
        sorted = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            locate.put(arr[i], i);  //위치 표시
            sorted[i] = arr[i];
        }

        //2. 배열 정렬
        Arrays.sort(sorted);

        //3. 교환
        for (int i = 0; i < N; i++) {
            if (arr[i] == sorted[i]) continue;

            int idx = locate.get(sorted[i]);
            locate.put(sorted[i], i);
            locate.put(arr[i], idx);
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
            rlt++;
        }
        System.out.println(rlt);
    }
}