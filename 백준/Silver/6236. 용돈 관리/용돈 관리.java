import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] moneyList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        moneyList = new int[N];

        int maxMoney = 0;
        for (int i = 0; i < N; i++) {
            moneyList[i] = Integer.parseInt(br.readLine());
            maxMoney = Math.max(maxMoney, moneyList[i]);
        }

        //이진탐색
        int left = maxMoney;
        int right = N * 10000;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            int tmpM = getWithdrawal(mid);
            if (M >= tmpM) {
                //지정 횟수보다 작으면 인출을 줄여서 확인
                result = mid;
                right = mid - 1;

            } else {
                //지정 횟수보다 크면 인출을 더 많이
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    //인출 횟수
    private static int getWithdrawal(int tmpK) {
        int cnt = 1;
        int money = tmpK;  //현재 인출 금액

        for (int i = 0; i < N; i++) {
            money -= moneyList[i];

            if (money < 0) {
                cnt++;
                money = tmpK - moneyList[i];
            }
        }
        return cnt;
    }
}
