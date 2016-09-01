/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        
        if (!s.startsWith("[")) 
            return new NestedInteger(Integer.parseInt(s));
       
        NestedInteger ni = new NestedInteger();
        
        int num = 0;
        int sign = 1;
        for (int i=1; i<s.length();) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                num = num*10+c-'0';
                if (!Character.isDigit(s.charAt(i))) {
                    ni.add(new NestedInteger(sign*num));
                    sign = 1;
                    num = 0;
                }
            } else if (c == '-') {
                sign = -1;
            } else if (c=='[') {
                int l = 1, r = 0;
                int j = i;
                while (l > r && j < s.length()) {
                    char c1 = s.charAt(j++);
                    if (c1 == '[') l++;
                    else if (c1 == ']') r++;
                } 
                
                ni.add(deserialize(s.substring(i-1,j)));
                i = j;
            }
        }

        return ni;
    }
}

