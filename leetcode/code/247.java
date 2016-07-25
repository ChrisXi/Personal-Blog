public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return get(n, n);
    }
    
    List<String> get(int n, int m) {
        if (m == 0) return new ArrayList<String>(Arrays.asList(new String[]{""}));
        else if (m == 1) return new ArrayList<String>(Arrays.asList(new String[]{"0","1","8"}));
        
        List<String> lst = get(n, m-2);
        List<String> ans = new ArrayList<String>();
    
        for (String str:lst) {
            if (m < n)
                ans.add("0"+str+"0"); 
            ans.add("1"+str+"1");ans.add("8"+str+"8");
            ans.add("6"+str+"9");ans.add("9"+str+"6");
        }
        
        return ans;
    }
}