import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        //참가자 수 저장
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        //완주자 차감
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        //결과 찾기
        for (String name : participant) {
            if (map.get(name) > 0) {
                return name;
            }
        }
        
        return "";
    }
}