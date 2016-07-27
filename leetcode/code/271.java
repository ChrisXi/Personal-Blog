public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        
        StringBuilder ans = new StringBuilder("");
        for(String str:strs) {
            ans.append(str.length()+"@");
            ans.append(str);
        }
        return ans.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<String>();
        int l = 0, r = 0;
        while (r < s.length()) {
            while (s.charAt(r) != '@') r++;
            int len = Integer.parseInt(s.substring(l, r++));
            ans.add(s.substring(r, r+len));    
            l = r = r+len;
        }
        
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));