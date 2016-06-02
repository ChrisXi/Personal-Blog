public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> map = new TreeSet<Integer>();
        
        for(int i=0; i<nums.length; i++) {
            
            if(map.floor(nums[i]) != null && Math.abs((long)nums[i]-(long)map.floor(nums[i])) <= t)
                return true;
                
            if(map.ceiling(nums[i]) != null && Math.abs((long)nums[i]-(long)map.ceiling(nums[i])) <= t)
                return true;
            
            map.add(nums[i]);
            if(i>=k)
                map.remove(nums[i-k]);
        }
        
        return false;
    }
}