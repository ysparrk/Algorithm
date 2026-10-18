class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int numberOfPeople = names.length;
      
        Integer[] indices = new Integer[numberOfPeople];
      
        Arrays.setAll(indices, i -> i);
      
        Arrays.sort(indices, (i, j) -> heights[j] - heights[i]);
      
        String[] sortedNames = new String[numberOfPeople];
      
        for (int i = 0; i < numberOfPeople; i++) {
            sortedNames[i] = names[indices[i]];
        }
      
        return sortedNames;
    }
}
