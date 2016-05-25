import java.util.HashMap;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums1.length; i++) {
            map.put(nums1[i],0);
        }
        
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for(int j=0; j<nums2.length; j++) {
            if(map.containsKey(nums2[j])) {
                int v= map.get(nums2[j]);
                
                if (v == 0) {
                    lst.add(nums2[j]);
                    map.put(nums2[j], 1);
                }
            } 
        }
        int[] ans = new int[lst.size()]; 
        for(int l=0; l<lst.size(); l++) {
            ans[l] = lst.get(l);
        }
        
        return ans;
    }
}