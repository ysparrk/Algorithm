import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] arr = new int[9];

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';

            if (num == 9) {
                num = 6;
            }
            arr[num]++;
        }
        
        arr[6] = arr[6] / 2 + arr[6] % 2;

        Arrays.sort(arr);
        System.out.println(arr[8]);
    }
}