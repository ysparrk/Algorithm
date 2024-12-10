import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static long[] nums;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.next());
        nums = new long[N];

        for (int i = 0; i < N; i++) {
            nums[i] = reverseNum(sc.next());
        }

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(nums[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static long reverseNum(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }
}