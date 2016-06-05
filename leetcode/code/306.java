public class Solution {
    public boolean isAdditiveNumber(String num) {
        
        for (int i=1; i<=num.length()/2; i++) {
            if(num.charAt(0) == '0' && i>=2)
                continue;
                
            for (int j=i+1; j<=num.length(); j++ ) {
                
                if(num.charAt(i) == '0' && j-i>=2)
                    continue;    
                    
                Long n1 = Long.parseLong(num.substring(0, i));
                Long n2 = Long.parseLong(num.substring(i, j));
                
                if (isAdditive(n1, n2, num.substring(j)))
                    return true;
            }
        }
        
        return false;
    }
    
    boolean isAdditive(Long n1, Long n2, String num) {
        
        for (int i=1; i<=num.length(); i++) {
            if(num.charAt(0) == '0' && i>=2)
                continue;
                
            Long n3 = Long.parseLong(num.substring(0,i));
            if (n1+n2 == n3) {
                
                if (i == num.length())
                    return true;
                
                if (isAdditive(n2, n3, num.substring(i)))
                    return true;
                
                break;
            }
        }    
        
        return false;
    }
}