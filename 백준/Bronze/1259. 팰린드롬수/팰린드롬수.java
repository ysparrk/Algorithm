import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            //1. input
            String number = br.readLine();

            int L = number.length();
            boolean flag = true;

            //2. exit
            if (number.equals("0")) {
                break;
            }

            //3. palindrome
            int i = 0;
            while (i < L / 2) {
                if (number.charAt(i) == number.charAt(L-i-1)) {
                    i++;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }
    }
}