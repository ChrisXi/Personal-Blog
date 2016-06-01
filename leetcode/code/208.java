class TrieNode {
    // Initialize your data structure here.
    boolean isFinished;
    TrieNode[] n;
    public TrieNode() {
        isFinished = false;
        n = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        
        TrieNode node = root;
        
        for(char c: word.toCharArray()) {
            if(node.n[c-'a'] == null) {
            	node.n[c-'a'] = new TrieNode();
            }
            node = node.n[c-'a'];
        }
        
        node.isFinished = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            node = node.n[c-'a'];
            if(node == null) {
                return false;
            }
        }
        
        return node.isFinished;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c: prefix.toCharArray()) {
            node = node.n[c-'a'];
            if(node == null) {
                return false;
            }
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");