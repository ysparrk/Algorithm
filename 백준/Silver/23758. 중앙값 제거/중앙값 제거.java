import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int K; //절반의 수
        if (N % 2 == 1) {
            K = (N / 2) + 1;
        } else {
            K = N / 2;
        }
        
        //0은 중간값 이하의 값들이 모두 1일때 나타남
        int answer = 0;
        for (int i = 0; i < K; i++) {
            int n = numbers[i];
            while (n > 1) {
                n = n / 2;
                answer += 1;
            }
        }
        System.out.println(answer + 1);
    }
}