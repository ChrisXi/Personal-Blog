public class TwoSum {
    
    Map<Integer,Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    map.put(number, map.getOrDefault(number, 0)+1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    
	    for (int i:map.keySet()) {
	        if (!map.containsKey(value-i)) continue;
	        if (value-i==i && map.get(value-i) <= 1) continue;
	        
	        return true;
	    }
	    
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);