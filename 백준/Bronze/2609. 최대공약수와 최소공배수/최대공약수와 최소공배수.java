/**
 * 최대공약수
 *  유클리드 호제법
 *  r = a mod b
 *  GCD(a, b) = GCD(b, r)
 *
 *  최소공배수
 *  a * b * d(최대공약수)
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        //최대공약수
        int d = gcd(num1, num2);

        System.out.println(d);
        System.out.println(num1 * num2 / d);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

}