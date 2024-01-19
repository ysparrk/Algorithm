/**
 * 이항계수
 * 두 개의 항을 전개하여 계수로 나타낸 것
 * (a+b)^n에 대해 전개했을 때, a^(n-r)b^r에 대한 계수
 * (a+b)^2 = a^2 + 2ab + b^ -> 계수 (1 2 1)
 * 조합 nCr
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(factorial(N) / (factorial(N-K) * factorial(K)));
    }

    static int factorial(int N) {
        if (N <= 1) {
            return 1;
        }
        return N * factorial(N - 1);
    }
}