public class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> ans = new ArrayList<String>();
        if(nums.length == 0)
            return ans;
            
        int last = nums[0];
        int mid = last;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != mid+1) {
                if(last == mid) {
                    ans.add(last+"");
                } else {
                    ans.add(last+"->"+mid);
                }
                last = nums[i];
                mid = last;
            } else {
                mid = nums[i];
            }
        }
        
        if(last == mid) {
            ans.add(last+"");
        } else {
            ans.add(last+"->"+mid);
        }
        
        return ans;
    }
}