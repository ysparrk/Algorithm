import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        long rlt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] - i <= 0) break;

            rlt += arr[i] - i;
        }
        System.out.println(rlt);
    }
}