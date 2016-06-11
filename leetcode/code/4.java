public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        return search(nums1, nums2, 0, 0, (len1+len2+1)/2)/2 +
               search(nums1, nums2, 0, 0, (len1+len2+2)/2)/2;
        
    }
    
    private double search(int[] nums1, int[] nums2, int s1, int s2, int k) {
        
        if (s1 > nums1.length-1) return nums2[s2+k-1];
        if (s2 > nums2.length-1) return nums1[s1+k-1];
        
        if (k==1) return Math.min(nums1[s1], nums2[s2]);
        
        int m1 = (s1+k/2-1<nums1.length ? nums1[s1+k/2-1]:Integer.MAX_VALUE);
        int m2 = (s2+k/2-1<nums2.length ? nums2[s2+k/2-1]:Integer.MAX_VALUE);
        
        if (m1 < m2)
            return search(nums1, nums2, s1+k/2, s2, k-k/2);
        else 
            return search(nums1, nums2, s1, s2+k/2, k-k/2);
    }
}