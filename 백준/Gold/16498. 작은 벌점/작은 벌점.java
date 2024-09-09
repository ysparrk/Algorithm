import java.io.*;
import java.util.*;

public class Main {

    private static int A, B, C;
    private static int[] a_lst, b_lst, c_lst, ab_max, ab_min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        a_lst = new int[A];
        b_lst = new int[B];
        c_lst = new int[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            a_lst[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            b_lst[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            c_lst[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(b_lst);
        Arrays.sort(c_lst);

        int rlt = Integer.MAX_VALUE;  //최소
        for (int i = 0; i < A; i++) {

            int a = a_lst[i];
            int b = getCloest(a, b_lst);
            int ca = getCloest(a, c_lst);
            int cb = getCloest(b, c_lst);
            
            rlt = Math.min(rlt, Math.abs(Math.max(Math.max(a, b), ca) - Math.min(Math.min(a, b), ca)));
            rlt = Math.min(rlt, Math.abs(Math.max(Math.max(a, b), cb) - Math.min(Math.min(a, b), cb)));

        }
        System.out.println(rlt);
    }

    private static int getCloest(int n, int[] lst) {
        //n와 가장 가까운 수 찾기
        int s = 0;
        int e = lst.length - 1;

        int mid = (s + e) / 2;
        int c = lst[mid]; //가장 가까운 값
        while (s <= e) {
            mid = (s + e) / 2;

            if (lst[mid] < n) s = mid + 1;
            else if (lst[mid] > n) e = mid - 1;
            else return lst[mid];

            //lst[mid]값으로 가장 가까운 값을 업데이트 할지 결정
            if (Math.abs(lst[mid] - n) < Math.abs(c - n)) c = lst[mid];
        }
        return c;
    }
}