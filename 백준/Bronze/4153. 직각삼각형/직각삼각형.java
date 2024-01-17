import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            //1. input
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int arr[] = new int[3];

            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            //2. exit
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }

            //3.
            Arrays.sort(arr);

            //직사각형 확인
            if (arr[2] * arr[2] == (arr[1] * arr[1]) + (arr[0] * arr[0])) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }
    }
}