public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        wordList.add(endWord);
        
        int ans = 1;
        while (! queue.isEmpty()) {
            ans ++;
            
            int size = queue.size(); //important!
            for (int n=0; n<size; n++) {
                
                char[] w = queue.poll().toCharArray();
            
                for (int i=0; i<w.length; i++) {
                    for (int j=0; j<27; j++) {
                        char c = w[i];
                        w[i] = (char)('a'+j);
                        String str = String.valueOf(w);
                        if (wordList.contains(str)) {
                            if (str.equals(endWord)) {
                                return ans;
                            } else {
                                queue.offer(str);
                                wordList.remove(str);
                            }
                        }
                        w[i] = c;
                    }
                }
            }
        }
        
        return 0;
    }
}