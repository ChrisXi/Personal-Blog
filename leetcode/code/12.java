public class Solution {
    public String intToRoman(int num) {
        
        String str = "";

    	int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    	String[] s = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    	for(int i=0; i<n.length; i++){
    		while(num >= n[i]) {
    			str = str + s[i];
    			num = num - n[i];
    		}
    	}

    	return str;
    }
}