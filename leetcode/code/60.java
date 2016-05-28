public class Solution {
    
    public String getPermutation(int n, int k) {
        
        List<Integer> lst = new ArrayList<Integer>();
        for(int i=1; i<=n; i++) {
            lst.add(i);
        }
        
        String ans = "";
        k--;
        while(n != 0) {
            int num = comNum(n);
            int p = k/num;
            ans += lst.get(p);
            lst.remove(p);
            k = k - (k/num)*num;
            n--;
        }
        
        return ans;
    }
    
    int comNum(int n) {
        int product = 1;
        for(int i=1; i<n; i++) {
            product*=i;
        }
        return product;
    }   
  
}