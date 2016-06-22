public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        
        while (rowIndex-- > 0) {
            
            ans.add(0, 0);
            for (int i=0; i<ans.size()-1; i++) 
                ans.set(i, ans.get(i)+ans.get(i+1));
        }
        
        return ans;
    }
}