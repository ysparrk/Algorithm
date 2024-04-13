import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        int N = Integer.parseInt(st.nextToken()); //접시 수
        int d = Integer.parseInt(st.nextToken()); //가짓수
        int k = Integer.parseInt(st.nextToken()); //연속 접시
        int c = Integer.parseInt(st.nextToken()); //쿠폰 번호

        int[] sushi = new int[N];
        int[] eat = new int[d + 1]; // i번째의 초밥을 몇 개 먹었는지

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        /**
         * 2. 슬라이딩 윈도우
         * 크기 k의 윈도우를 옮긴다
         * 1) 초기값 만들기(0~k-1번, 총 k개)
         * 2) 시작값(1~N)에서의 초밥 가짓수 세기
         */

        //2-1)
        int cnt = 0; //먹은 초밥 가짓수 초기값
        for (int i = 0; i < k; i++) {
            if (eat[sushi[i]] == 0) {
                cnt++;
            }
            eat[sushi[i]]++;
        }


        //2-2)
        int max_rlt = cnt;
        for (int start = 1; start < N + 1; start++) {
            // max 갱신
            if (max_rlt <= cnt) {
                if (eat[c] == 0) {
                    max_rlt = cnt + 1;
                } else {
                    max_rlt = cnt;
                }
            }

            //1) end 이동 -> end에서의 eat 갱신
            int end = (start + k - 1) % N;
            if (eat[sushi[end]] == 0) {
                cnt++;
            }
            eat[sushi[end]]++;

            //2) start이동 -> 기존 start에서의 eat 초기화
            if (--eat[sushi[start - 1]] == 0) {
                cnt--;
            }
        }
        System.out.println(max_rlt);
    }
}