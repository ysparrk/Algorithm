import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. input
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }


        //2. 완전탐색
        int maxCnt = 0;
        for (int i = 0; i < N; i++) {

            int before = nums[0];

            int tmpCnt = 1;
            for (int j = 1; j < N; j++) {

                if (nums[i] == nums[j]) continue;

                if (before == nums[j]) {
                    tmpCnt++;
                } else {
                    maxCnt = Math.max(maxCnt, tmpCnt);
                    tmpCnt = 1;  //초기화
                    before = nums[j];
                }
            }
            maxCnt = Math.max(maxCnt, tmpCnt);
        }
        System.out.println(maxCnt);
    }
}