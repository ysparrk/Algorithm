import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. input
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        // 2. value
        int val = A * B * C;

        String str = String.valueOf(val);
        
        // 3. 배열 선언 + result
        int[] arr = new int[10];

        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            arr[(str.charAt(i) - 48)]++;
        }
        
        // 4. print
        for (int a : arr) {
            System.out.println(a);
        }
    }
}