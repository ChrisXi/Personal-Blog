public class Solution {
    
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        
        getIP(ans, new ArrayList<Integer>(), s);
        
        return ans;
    }

    void getIP(List<String> ans, ArrayList<Integer> ips, String str) {
        
        if(ips.size() == 4) {
            if(str.equals("")) {
                ans.add(ips.get(0)+"."+ips.get(1)+"."+ips.get(2)+"."+ips.get(3));
            } 
            return;
        }
        
        int len=1;
        while(str.length()>=len) {
            int ip = Integer.parseInt(str.substring(0, len));
            if(ip<=255) {
                ips.add(ip);
                getIP(ans, ips, str.substring(len));
                ips.remove(ips.size()-1);
                
                if(ip != 0) {
                    len++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }
}