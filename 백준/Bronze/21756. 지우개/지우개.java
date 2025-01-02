import java.io.*;
import java.util.ArrayList;

public class Main {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            arr.add(i);
        }

        while(arr.size() >= 2) {
            for(int i = 0; i < arr.size(); i++) {
                arr.remove(i);
            }
        }
        System.out.println(arr.get(0));
    }
}