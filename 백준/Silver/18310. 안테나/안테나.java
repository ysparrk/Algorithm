import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());
        house = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }

        //2. 가운데로 모으기 -> 중점
        Arrays.sort(house);

        System.out.println(house[(N-1)/2]);
    }
}