public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        if(numerator == 0) 
            return "0";
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        StringBuilder ans = new StringBuilder("");
        
        long nu = Math.abs((long)numerator);
        long de = Math.abs((long)denominator);
        
        if(((long)numerator)/nu + ((long)denominator)/de == 0)
            ans.append("-");
        
        if(Math.abs(nu) > Math.abs(de)) {
            if(nu%de == 0) {
                ans.append((nu/de)+"");
            } else {
                ans.append((nu/de)+".");
                nu %= de;
            }
        } else {
            ans.append("0.");
        }
        
        while(nu%de != 0) {
           long re = nu;
           if(map.containsKey((int)re)) {
               int pos = map.get((int)re);
               ans.insert(pos, '(');
               ans.append(")");
               break;
           } else {
               map.put((int)re, ans.length());
           }

           re *= 10;
           
           while(re < de) {
               ans.append("0");
               map.put((int)re, ans.length());
               
               re *= 10;
           }
           
           ans.append(re/de);
           nu = re%de;
        }
        
        return ans.toString();
        
    }
}