import java.util.HashMap;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums1.length; i++) {
            int n = map.getOrDefault(nums1[i], 0);
            map.put(nums1[i], n+1);
        }
        
        List<Integer> lst = new ArrayList<Integer>();
        for(int j=0; j<nums2.length; j++) {
            int n = map.getOrDefault(nums2[j], 0);
            if(n > 0) {
                lst.add(nums2[j]);
                map.put(nums2[j], n-1);
            }
        }
        
        int[] ans = new int[lst.size()]; 
        for(int l=0; l<lst.size(); l++) {
            ans[l] = lst.get(l);
        }
        
        return ans;
    }
}