import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. input
        int[] people = new int[9];
        int nineSum = 0;
        for (int i = 0; i < 9; i++) {
            people[i] = Integer.parseInt(br.readLine());
            nineSum += people[i];
        }


        //2. 일곱난쟁이가 아닌 경우 제거
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (people[i] + people[j] == nineSum - 100) {
                    people[i] = -1;
                    people[j] = -1;

                    //3. 정렬 + result
                    Arrays.sort(people);
                    StringBuilder sb = new StringBuilder();
                    for (int k = 2; k < 9; k++) {
                        sb.append(people[k] + "\n");
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}