import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] currentStage = new double[N+1];
        double[] totalUser = new double[N+1];
        List<double[]> fail = new ArrayList<double[]>();
        
        for (int i=0; i<stages.length; i++) {
            currentStage[stages[i]-1]++; 
            for (int j=0; j<stages[i]; j++) {
                totalUser[j]++; 
            }
        }
        
        for (int i=0; i<N; i++) {
            if(totalUser[i] == 0) {
                fail.add(new double[]{i,0});
            } else {
                fail.add(new double[]{i,currentStage[i] / totalUser[i]});
            }
        }
        
        fail.sort((a,b)->Double.compare(b[1],a[1]));
        
        for (int i=0; i<fail.size(); i++) {
            answer[i] = (int)fail.get(i)[0]+1;
        }
        
        return answer;
    }
}