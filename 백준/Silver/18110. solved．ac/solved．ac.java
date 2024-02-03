import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);  //정렬

        int del = (int) Math.round(N * 0.15);  

        int[] arr = Arrays.copyOfRange(nums, del, N - del);  // 슬라이싱

        int average = (int) Math.round(Arrays.stream(arr).average().orElse(0));

        System.out.println(average);
    }
}