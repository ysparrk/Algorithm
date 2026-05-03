import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        
        List<String> spoiler = new ArrayList<>();
        Set<String> notSpoiler = new HashSet<>();
        
        int curIdx = 0;
        for (String word : message.split(" ")) {
            
            int start = message.indexOf(word, curIdx);
            int end = start + word.length() - 1;
            curIdx = end + 1;
            
            //스포일러 범위에 걸치는지 확인
            boolean isSpoiler = false;
            for (int[] range : spoiler_ranges) {
                if (start <= range[1] && end >= range[0]) {
                    spoiler.add(word);
                    isSpoiler = true;
                    break;
                }
            }
            
            if (!isSpoiler) {
                notSpoiler.add(word);
            }
        }
        
        //중요한 단어인지 확인
        Set<String> important = new HashSet<>();
        for (String word : spoiler) {
            if (!notSpoiler.contains(word) && !important.contains(word)) {
                important.add(word);
            }
        }
        
        return important.size();
    }
}