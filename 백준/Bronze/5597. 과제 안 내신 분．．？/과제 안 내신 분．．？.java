import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 31개의 배열 만들고, 학생이 있으면 해당 인덱스에 1 표시
        int[] students = new int[31];
        for (int i = 1; i < 29; i++) {
            int num = Integer.parseInt(br.readLine());
            students[num] = 1;
        }
        br.close();

        // 2. 1이 없는 인덱스 찾기
        for (int i = 1; i <= 30; i++) {
            if (students[i] != 1)
                bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}