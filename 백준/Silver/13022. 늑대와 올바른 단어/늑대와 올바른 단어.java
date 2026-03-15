import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String test = "(w+o+l+f+)+";
        int w = 0, o = 0, l = 0, f = 0;
        boolean check = false;

        for (int i = 0; i <S.length(); i++) {
            if(S.charAt(i) == 'w')
                w++;
            else if(S.charAt(i) == 'o')
                o++;
            else if(S.charAt(i) == 'l')
                l++;
            else
                f++;

            if (i < S.length()-1 && S.charAt(i)=='f' && S.charAt(i + 1)=='w') {
                if(!(w==o && o==l
                        && l==f && f == w)) {
                    check = true;
                    break;
                }
            }
        }

        if(!check && S.matches(test)
                && w == o
                && o == l
                && l == f
                && f == w)
            System.out.println(1);
        else
            System.out.println(0);
    }
}