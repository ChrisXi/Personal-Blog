public class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return;
        
        findMedian(nums);
        
        int m = (len-1)/2 + (len-1)%2;
        int median = nums[m];
        
        int j = 0;
        for (int i=0; i<m; i++) 
            if (nums[i] > median) 
                swap(nums, i, j++);
                
        j = len-1;
        for (int i=len-1; i>m; i--) 
            if (nums[i] < median) 
                swap(nums, i, j--);  
        
        int i=0, r=len-1, l=0;
        while (i <= r) {
            int newIndex = newIndex(i, m);
            if (nums[newIndex] > median) {
                swap(nums, newIndex, newIndex(l++, m));
                i++;
            } else if (nums[newIndex] < median) {
                swap(nums, newIndex, newIndex(r--, m));
            } else {
                i++;
            }
        }
    }
    
    int newIndex(int i, int m) {
        return i<m ? i*2+1:(i-m)*2;
    }
    
    void swap(int[] nums, int n1, int n2) {
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }
    
    void findMedian(int[] nums) {
        
        int len = nums.length;
            
        int m = (len-1)/2 + (len-1)%2;
        
        int s=0, e=len-1;
        while (s<e) {
            int flag = nums[e];
            int p = s;
            for (int i=s; i<e; i++) {
                if (nums[i] >= flag) {
                    swap(nums, p, i);
                    p ++;
                }
            }
            swap(nums, p, e);
            
            if (m == p) return;
            else if (m < p) e = p-1;
            else s = p+1;
        } 
    }
}