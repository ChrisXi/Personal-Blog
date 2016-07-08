public class Solution {
    public int findPeakElement(int[] nums) {
        int s=0;
        int e=nums.length-1;

        while(s+1<e) {
        	int m = s+(e-s)/2;
        	if(nums[m]<nums[m+1]) {
        		s = m+1;
        	} else {
        		e = m;
        	}
        }

        return nums[s]<nums[e] ? e:s;
    }
}