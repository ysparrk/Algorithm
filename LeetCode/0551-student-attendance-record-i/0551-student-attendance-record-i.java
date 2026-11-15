class Solution {

    public boolean checkRecord(String s) {
        boolean hasAtMostOneAbsence = s.indexOf("A") == s.lastIndexOf("A");
      
        boolean noThreeConsecutiveLates = !s.contains("LLL");
      
        return hasAtMostOneAbsence && noThreeConsecutiveLates;
    }
}
