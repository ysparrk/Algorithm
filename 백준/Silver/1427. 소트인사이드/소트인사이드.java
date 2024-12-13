import java.io.*;
import java.util.*;

public class Main {
    private static char[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nums = br.readLine().toCharArray();

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            sb.append(nums[i]);
        }

        System.out.println(sb);
    }
}