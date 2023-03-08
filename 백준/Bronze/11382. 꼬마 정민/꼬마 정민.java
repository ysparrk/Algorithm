import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // a, b, c의 범위가 1부터 10^12이기 때문에 long 타입으로 값 받는다.
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        System.out.println(a + b + c);
    }
}