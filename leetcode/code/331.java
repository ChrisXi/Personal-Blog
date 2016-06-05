public class Solution {
    public boolean isValidSerialization(String preorder) {
        
        String[] strs = preorder.split(",");
        
        int down=0, up=-1;
        for (String str : strs) {
            up ++;
            if (up > down)
                return false;
                
            if (!str.equals("#")) {
                down += 2;    
            }
        }
            
        return up == down;
    }
}