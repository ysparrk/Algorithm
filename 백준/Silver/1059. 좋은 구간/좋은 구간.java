import java.io.*;
import java.util.*;

public class Main {
    private static int L, N;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = Integer.parseInt(br.readLine());
        arr = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        N = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0;
        int end = 0;

        if (arr[0] > N) end = arr[0];
        else {
            for (int i = 0; i < L - 1; i++) {
                if (arr[i] == N || arr[i + 1] == N) {
                    System.out.println(0);
                    return;
                }

                if (arr[i] < N && arr[i + 1] > N) {
                    start = arr[i];
                    end = arr[i + 1];
                }
            }
        }
        
        int arr1 = N - start - 1;
        int arr2 = end - N - 1;
        int rlt = arr1 + arr2 + arr1 * arr2;

        System.out.println(rlt);
    }
}