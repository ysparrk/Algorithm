class Solution {
    public int solution(String s) {
        
        String[] nums = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for (int i = 0; i < 10; i++) {
            s = s.replace(nums[i], Integer.toString(i));
        }
 
        return Integer.parseInt(s);  // int로 변환하여 return
    }
}