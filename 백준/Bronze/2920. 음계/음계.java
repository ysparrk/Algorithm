import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        boolean ascFlag = false;
        boolean dscFlag = false;
        int umm = Integer.parseInt(st.nextToken());  // 첫번째 음

        for (int i = 1; i < 8; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (umm < temp) {
                ascFlag = true;
            } else {
                dscFlag = true;
            }
            umm = temp;
        }

        if (ascFlag == true && dscFlag == false) {
            System.out.println("ascending");
        } else if (ascFlag == false && dscFlag == true) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }
}