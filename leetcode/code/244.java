public class WordDistance {
    
    Map<String, List<Integer>> map = new HashMap<>();
    
    public WordDistance(String[] words) {
        for (int i = 0; i<words.length; i++) {
            List<Integer> lst = map.getOrDefault(words[i], new ArrayList<Integer>());
            lst.add(i);
            map.put(words[i], lst);
        }
    }

    public int shortest(String word1, String word2) {
        
        List<Integer> lst1 = map.get(word1), lst2 = map.get(word2);
        int ans = Integer.MAX_VALUE;
        
        int i=0, j=0;
        while (i<lst1.size() && j<lst2.size()) {
            int p1 = lst1.get(i), p2 = lst2.get(j);
            ans = Math.min(ans, Math.abs(p1-p2));
            if (p1 < p2) i ++;
            else j ++;
        }
        
        return ans;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");