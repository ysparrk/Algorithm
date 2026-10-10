import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        int N = people.length;
        Arrays.sort(people);
        
        int start = 0;
        int end = N - 1;
        int result = 0;
        
        while (start <= end) {
            if (start == end) {
                result += 1;
                break;
            }
            
            if (people[start] + people[end] <= limit) {
                result++;
                start++;
                end--;
            } else {
                result += 1;
                end--;
            }
        } 
        
        return result;
    }
}