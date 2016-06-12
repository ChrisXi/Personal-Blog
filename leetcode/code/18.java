public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for (int i=0; i<nums.length-3; ) {
            for (int j=i+1; j<nums.length-2;) {
                
                int l=j+1, h=nums.length-1;
                
                while (l<h) {
                    int sum = nums[i]+nums[j]+nums[l]+nums[h];
                    if (sum<target) {
                        l++;
                    } else if (sum==target) {
                        
                        ans.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[l],nums[h]}));
                        
                        int temp = nums[l];
                        while(l<h && temp==nums[l]) {l++;}
                        temp = nums[h];
                        while(l<h && temp==nums[h]) {h--;}
                    } else {
                        h--;
                    }
                }
                
                int temp = nums[j];
                while(j<nums.length-2 && temp==nums[j]) {j++;}
            }
            int temp = nums[i];
            while(i<nums.length-3 && temp==nums[i]) {i++;}
        }
        
        return ans;
    }
}