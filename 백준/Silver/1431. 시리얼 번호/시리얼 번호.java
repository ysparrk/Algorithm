import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] serial = new String[N];

        for (int i = 0; i < N; i++) {
            serial[i] = br.readLine();
        }

        Arrays.sort(serial, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                //1) 길이가 다를때
                if (o1.length() < o2.length()) {
                    return -1;
                }
                //2) 길이가 같을 때
                else if (o1.length() == o2.length()) {
                    if (compareSum(o1) == compareSum(o2)) {
                        return o1.compareTo(o2);  //오름차순 정렬
                    } else {
                        return Integer.compare(compareSum(o1), compareSum(o2));
                    }
                }
                else {
                    return 1;
                }
            }
        });

        for (String s : serial) {
            System.out.println(s);
        }

    }

    public static int compareSum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sum += str.charAt(i) - '0';
            }
        }
        return sum;
    }
}