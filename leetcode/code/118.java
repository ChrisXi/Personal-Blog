public class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        while (numRows > 0) {
            List<Integer> temp = new ArrayList<Integer>();  
            
            if (ans.size() == 0) {
                temp.add(1);
                ans.add(temp);
                numRows --;
                continue;
            }
            
            List<Integer> last = ans.get(ans.size()-1);
            temp.add(last.get(0));
            
            for (int i=0; i<last.size()-1; i++) 
                temp.add(last.get(i)+last.get(i+1));
            
            temp.add(last.get(last.size()-1));
            ans.add(temp);
            numRows --;
        }
        return ans;
    }
}