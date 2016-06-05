public class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int len = nums.length;
        k--;
        
        int s=0, e=len-1;
        while (s<=e) {
            int flag = nums[e];
            int p = s;
            for (int i=s; i<e; i++) {
                if (nums[i] >= flag) {
                    swap(nums, p, i);
                    p ++;
                }
            }
            swap(nums, p, e);
            
            if (k == p)
                return nums[k];
            else if (k < p)
                e = p-1;
            else 
                s = p+1;
        }
        
        return nums[k];
    }
    
    void swap(int[] nums, int n1, int n2) {
        int temp = nums[n1];  
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }
}