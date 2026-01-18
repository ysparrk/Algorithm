import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int N, cnt, pressFirstCnt;
    private static char[] bulbs, pressFirst, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        bulbs = br.readLine().toCharArray();             //첫번째 스위치를 누르지 않는 경우
        pressFirst = Arrays.copyOf(bulbs, bulbs.length); //첫번째 스위치를 누른 경우

        changeSwitch(0, pressFirst);
        changeSwitch(1, pressFirst);

        target = br.readLine().toCharArray();

        cnt = 0;  //첫번째 스위치를 안누른 경우
        pressFirstCnt = 1; //첫번째 스위치를 누른 경우

        for (int i = 1; i < N; i++) {

            //첫번째 스위치를 누르지 않은 경우
            if (bulbs[i - 1] != target[i - 1]) {
                changeSwitch(i - 1, bulbs);
                changeSwitch(i, bulbs);

                if (i + 1 < N) {
                    changeSwitch(i + 1, bulbs);
                }
                cnt++;
            }

            //첫번째 스위치를 누른 경우
            if (pressFirst[i - 1] != target[i - 1]) {
                changeSwitch(i - 1, pressFirst);
                changeSwitch(i, pressFirst);

                if (i + 1 < N) {
                    changeSwitch(i + 1, pressFirst);
                }

                pressFirstCnt++;
            }
        }
        
        //둘 중 타겟과 일치하는지 확인
        if (checkTarget(bulbs)) {
            System.out.println(cnt);
        } else if (checkTarget(pressFirst)) {
            System.out.println(pressFirstCnt);
        } else {
            System.out.println(-1);
        }
    }

    private static void changeSwitch(int idx, char[] bulbList) {
        if (bulbList[idx] == '0') {
            bulbList[idx] = '1';
        } else {
            bulbList[idx] = '0';
        }
    }

    private static boolean checkTarget(char[] bulbList) {
        for (int i = 0; i < N; i++) {
            if (target[i] != bulbList[i]) {
                return false;
            }
        }
        return true;
    }
}