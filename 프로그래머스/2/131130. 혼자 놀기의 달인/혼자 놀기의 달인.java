import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int cardCnt = cards.length;

        boolean[] visited = new boolean[cardCnt];

        List<Integer> sizeList = new ArrayList<>();
        for (int i = 0; i < cardCnt; i++) {
            if (!visited[i]) {
                sizeList.add(getSize(i, visited, cards));
            }
        }

        if (sizeList.size() < 2) return 0;

        sizeList.sort(Comparator.reverseOrder());
        return sizeList.get(0) * sizeList.get(1);
    }

    private int getSize(int start, boolean[] visited, int[] cards) {
        int size = 0;
        int cur = start;

        while (!visited[cur]) {
            visited[cur] = true;
            cur = cards[cur] - 1;
            size++;
        }
        return size;
    }
}