public class Solution {
   
    class EntryComparator<K, V extends Comparable<V>> implements Comparator<Map.Entry<K, V>> {
        public int compare(Map.Entry<K,V> m1, Map.Entry<K,V> m2) {
            return m2.getValue().compareTo(m1.getValue());
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.computeIfPresent(nums[i], (key,v)->v+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>> (new EntryComparator());
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            queue.offer(e);
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=1; i<=k; i++) {
            ans.add(queue.poll().getKey());
        }
        
        return ans;
    }
}