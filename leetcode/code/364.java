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
class Data {
    int depth;
    int value;
    Data(int value, int depth) {
        this.depth = depth;
        this.value = value;
    }
}

public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        
        List<Data> lst = new ArrayList<Data>();
        int maxDepth = getSum(nestedList, lst, 1);
        int ans = 0;
        for(int i=0; i<lst.size(); i++) 
            ans += (maxDepth-lst.get(i).depth+1)*lst.get(i).value;
        
        return ans;
    }
    
    int getSum(List<NestedInteger> nestedList, List<Data> lst, int depth) {
        int maxDepth = depth;
        for (NestedInteger n:nestedList) {
            if (n.isInteger()) 
                lst.add(new Data(n.getInteger(), depth));
            else 
                maxDepth = Math.max(maxDepth, getSum(n.getList(), lst, depth+1));
        }
        return maxDepth;
    }
}