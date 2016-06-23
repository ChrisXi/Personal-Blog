public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        
        Queue<String> queue = new LinkedList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        queue.offer(beginWord);
        wordList.add(endWord);
        
        int level = 1;
        while (! queue.isEmpty()) {
            
            int size = queue.size();
            Set<String> removeLst = new HashSet<String>();
            boolean find = false;
            for (int n=0; n<size; n++) {
                String str = queue.poll();
                char[] w = str.toCharArray();
                
                for (int i=0; i<w.length; i++) {
                    for (int j=0; j<27; j++) {
                        char c = w[i];
                        w[i] = (char)('a'+j);
                        String newStr = String.valueOf(w);
                        if (wordList.contains(newStr)) {
                            List<String> lst = map.getOrDefault(str, new ArrayList<String>());
                            lst.add(newStr);
                            map.put(str, lst);
                            removeLst.add(newStr);
                            
                            find = newStr.equals(endWord) ? true:find;
                        }
                        w[i] = c;
                    }
                }
            }
            for (String s:new ArrayList<String>(removeLst)) {
            	queue.offer(s);
                wordList.remove(s);
            }
            
            level ++;
            if (find) break;
        }
        
        List<List<String>> ans = new ArrayList<List<String>>();
        search(ans, new ArrayList<String>(), new HashSet<String>(), beginWord, endWord, map, level);
        
        return ans;
    }
    
    void search(List<List<String>> ans, List<String> lst, Set<String> set, String beginWord, String endWord, Map<String, List<String>> map, int level) {
        if (set.contains(beginWord))
            return;
        
        lst.add(beginWord);
        if (level == 1) {
            if (beginWord.equals(endWord)) 
                ans.add(new ArrayList<String>(lst));
        } else {
            List<String> wordLst = map.getOrDefault(beginWord, new ArrayList<String>());
            for (int i=0; i<wordLst.size(); i++) 
                search(ans, lst, new HashSet<String>(lst), wordLst.get(i), endWord, map, level-1);
        }
        lst.remove(beginWord);
    }
}