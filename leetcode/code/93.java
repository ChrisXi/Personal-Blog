public class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> ans = new ArrayList<String>();
        
        add (ans, new ArrayList<Integer>(), s);
        
        return ans;
    }
    
    void add (List<String> ans, List<Integer> ips, String s) {
        
        int len = Math.min(s.length(),3);
        
        if (ips.size() > 4) return;
        
        if (len == 0) {
            if (ips.size() == 4) {
                StringBuilder str = new StringBuilder("");
                str.append(ips.get(0)+"."+ips.get(1)+"."+ips.get(2)+"."+ips.get(3));
                ans.add(str.toString());
            }
            return;
        }
        
        len = (s.charAt(0)=='0' ? 1:len);
        int n = 0;
        for (int i=0; i<len; i++) {
            n = n*10 + (s.charAt(i)-'0');
            if (n <= 255) {
                ips.add(n);
                add(ans, ips, s.substring(i+1));
                ips.remove(ips.size()-1);
            } else break;
        }
    }
}