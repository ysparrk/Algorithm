import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1.
        int[] arr = new int[10];
        boolean bl; // 비교할 변수
        int cnt = 0;

        // 2. 배열에 나머지 넣기
        for(int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine()) % 42;  // 42로 나눈 나머지를 배열에 넣기
        }

        // 3. 배열 안에서 중복하지 않는 값 cnt
        for(int i = 0; i < 10; i++) {
            bl = false;  // 기본값 false
            // 3-2. 배열에서 해당 인덱스 뒤의 모든 값들과 비교한다.
            for (int j = i + 1; j < 10; j++) {
                if (arr[i] == arr[j]) {
                    bl = true;  // 중복값 -> true로 변경 후 break
                    break;
                }
            }
            // 3-2. 비교했을때, false라면 cnt++
            if (bl == false) {
                cnt++;
            }
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        
    }
}