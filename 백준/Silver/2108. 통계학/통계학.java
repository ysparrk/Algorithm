import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /**
         * counting sort
         * 1. min, max
         * 2. sum
         */
        int[] cntArray = new int[8001];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            cntArray[value + 4000]++;  //카운팅 정렬
            sum += value;

            if (value > max) {
                max = value;
            }

            if (value < min) {
                min = value;
            }
        }


        /**
         * cntArray (min ~ max)
         * 1. median
         * 2. mode
         */

        int cntMedian = 0;  // 중앙값
        int cntModeMax = 0;  //최빈값
        int mode = 0;
        boolean modeFlag = false;
        int median = 0;
        for (int i = min + 4000; i <= max + 4000; i++) {

            if (cntArray[i] > 0) {

                //1) median
                if (cntMedian < (N+1) / 2) {
                    median = i - 4000;
                    cntMedian += cntArray[i];
                }

                //2) mode
                if (cntArray[i] > cntModeMax) {
                    cntModeMax = cntArray[i];
                    modeFlag = true;  //새로 등장 -> flag 키기
                    mode = i - 4000;
                } else if (cntArray[i] == cntModeMax && modeFlag) {
                    mode = i - 4000; //두번째로 작은 값
                    modeFlag = false;
                }
            }
        }


        //3. result
        System.out.println((int) Math.round((double) sum / N));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max - min);
    }
}