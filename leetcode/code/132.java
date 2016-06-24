public class Solution {
    public int minCut(String s) {
        
        int len = s.length();
        boolean[][] isPal = new boolean[len][len];
        int[] cut = new int[len];
        
        for (int i=0; i<len; i++) {
            cut[i] = i;
            for (int j=0; j<=i; j++) {
                if (s.charAt(i)==s.charAt(j) && (j+1 > i-1 || isPal[i-1][j+1])) {
                    isPal[i][j] = true;
                    cut[i] = (j==0 ? 0:Math.min(cut[i], cut[j-1]+1));   
                }
            }
        }
        
        return cut[len-1];
    }
}