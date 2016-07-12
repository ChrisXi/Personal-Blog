public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->(Integer.compare(a[0]+a[1], b[0]+b[1])));
        for (int i=0; i<nums1.length; i++)
            for (int j=0; j<nums2.length; j++) 
                queue.offer(new int[]{nums1[i], nums2[j]});
        
        List<int[]> ans = new ArrayList<>();
        for (int i=0; i<k; i++)
            if (queue.size() > 0)
                ans.add(queue.poll());
        
        return ans;
    }
}