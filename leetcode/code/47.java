import java.util.HashSet;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> ansHash = new HashSet<List<Integer>>();
        
        
        ArrayList<Integer> numlst = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++) {
            numlst.add(nums[i]);
        }
        
        add(ansHash, numlst, new ArrayList<Integer>());
        
        List<List<Integer>> ansLst = new ArrayList<List<Integer>>(ansHash);
        return ansLst;
        
    }

    public void add(HashSet<List<Integer>> ans, ArrayList<Integer> numlst, ArrayList<Integer> ns) {
        if(numlst.size() == 0) {
            ans.add(new ArrayList<Integer>(ns));
            return;
        }
        
        for(int i=0; i<numlst.size(); i++) {
            int n = numlst.get(i);
            numlst.remove(i);
            ns.add(n);
            add(ans, numlst, ns);
            ns.remove(ns.size()-1);
            numlst.add(i, n);
        }
        
    }
}


