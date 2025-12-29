import java.util.*;

class Solution {
    
    private static int height, cnt, column, row;
    private static int[][] box;
    
    public int solution(int n, int w, int num) {
        
        height = (n / w) + 1;
        box = new int[height][w];
        cnt = 1;

        column = 0;
        row = 0;
        
        for(int i = 0; i < height; i++) {
            if(i % 2 == 0) {
                for (int j = 0; j < w; j++) {
                    if(cnt > n) break;
                    
                    if(cnt == num) {
                        column = i;
                        row = j;
                    }
                    
                    box[i][j] = cnt++;
                }
                
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    if(cnt > n) break;
                    
                    if(cnt == num) {
                        column = i;
                        row = j;
                    }
                    box[i][j] = cnt++;
                }
            }
        }
        
        int answer = 0;
        for(int i = column; i < height; i++) {
            if(box[i][row] != 0) {
                answer++;
            }
        }
        
        return answer;
    }
}