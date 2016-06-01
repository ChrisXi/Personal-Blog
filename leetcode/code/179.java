class NumComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        return (s2+s1).compareTo(s1+s2);
    }
}

public class Solution {

    public String largestNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<String>(new NumComparator());
        
        for(int n: nums) {
            queue.offer(n+"");
        }
        
        StringBuilder ans = new StringBuilder("");
        while(queue.size() != 0) {
            ans.append(queue.poll());
        }
        
        String str= ans.toString();
        
        if(ans.length() > 0 && ans.charAt(0) == '0')
            return "0";
        
        return ans.toString();
    }
}