class Solution {
    public int longestStrChain(String[] words) {

        Arrays.sort(words, Comparator.comparingInt(String::length));

        HashMap<String, Integer> dp = new HashMap<>(); //word로 끝나는 가장 긴 String Chain의 길이

        int maxLen = 1;
        for (String word : words) {
            int tmp = 1;

            //word에서 문자 하나씩 제거
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);

                //prev가 이전에 존재했다면 
                if (dp.containsKey(prev)) {
                    tmp = Math.max(tmp, dp.get(prev) + 1);
                    maxLen = Math.max(maxLen, tmp);
                }
            }
            //현재 word로 끝나는 최대 chain 저장
            dp.put(word, tmp);
        }

        return maxLen;
    }
}