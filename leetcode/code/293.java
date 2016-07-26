public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<String>();
        char[] cs = s.toCharArray();
        for (int i=0; i<=cs.length-2; i++) {
            if (cs[i]=='+' && cs[i+1]=='+') {
                cs[i] = '-';
                cs[i+1] = '-';
                ans.add(String.valueOf(cs));
                cs[i] = '+';
                cs[i+1] = '+';
            }
        }
        return ans;
    }
}