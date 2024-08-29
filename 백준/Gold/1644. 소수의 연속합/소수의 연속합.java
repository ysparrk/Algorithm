import java.io.*;

public class Main {

    private static int N;
    private static boolean[] notPrime;

    private static void makePrime() {
        //소수 : false
        notPrime[0] = true;
        notPrime[1] = true;
        notPrime[N + 1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    notPrime[j] = true;
                }
            }
        }
    }

    private static int getPrime(int idx) {
        while (idx <= N) {
            if (!notPrime[++idx]) {
                break;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. input
        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        notPrime = new boolean[N + 2];
        makePrime();


        //2. 투포인터
        int s = 2;
        int e = 2;
        int cnt = 0;
        int total = 2;
        while (e <= N) {

            if (total < N) {
                e = getPrime(e);
                total += e;
            } else if (total > N) {
                total -= s;
                s = getPrime(s);
            } else {
                cnt++;
                e = getPrime(e);
                total += e;
                total -= s;
                s = getPrime(s);
            }
        }
        System.out.println(cnt);
    }
}