import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //1. input
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  //배열에 넣음
        }

        //2. Result
        int rlt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if (rlt < temp && temp <= M) {
                        rlt = temp;
                    }
                }
            }
        }
        System.out.println(rlt);
    }
}