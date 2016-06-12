public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length-2; ) {
            
            int l=i+1, h=nums.length-1;
            
            while (l < h) {
                int sum=nums[i]+nums[l]+nums[h];
                if (sum > 0) {
                    h--;
                } else if (sum ==0) {
                    ans.add(Arrays.asList(new Integer[]{nums[i],nums[l],nums[h]}));
                    int temp = nums[h];
                    while (l<h && nums[h]==temp){h--;}
                    temp = nums[l];
                    while (l<h && nums[l]==temp){l++;}
                } else {
                    l++;
                }
            }
            
            int temp = nums[i];
            while (i<nums.length-2 && nums[i]==temp){i++;}
        }
        
        return ans;
    }
}