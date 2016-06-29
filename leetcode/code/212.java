class Node {
    Node[] nodes;
    boolean isEnd;
    Node() {
        nodes = new Node[26];
        isEnd = false;
    }
}

public class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
        
        Node root = new Node();
        
        for (int i=0; i<words.length; i++) {
            Node node = root;
            for (int j=0; j<words[i].length(); j++) {
                char c = words[i].charAt(j);
                int index = c-'a';
                if (node.nodes[index] == null) {
                    node.nodes[index] = new Node();
                }   
                node = node.nodes[index];
            }
            node.isEnd = true;
        }
        
        List<String> ans = new ArrayList<String>();
        
        for (int i=0; i<board.length; i++) 
            for (int j=0; j<board[0].length; j++)
                search(ans, root, board, new boolean[board.length][board[0].length], i, j, "");
        
        return ans;
    }
    
    void search(List<String> ans, Node node, char[][] board, boolean[][] visited, int i, int j, String s) {
        
        int h = board.length, w = board[0].length;
        
        if (0<=i && i<h && 0<=j && j<w && !visited[i][j]) {
            
            int index = board[i][j]-'a';
            if (node.nodes[index] != null) {
                
                s += board[i][j];
                if (node.nodes[index].isEnd) {
                    ans.add(s);
                    node.nodes[index].isEnd = false; //remove duplicate
                }
                
                visited[i][j] = true;
                search(ans, node.nodes[index], board, visited, i+1, j, s);   
                search(ans, node.nodes[index], board, visited, i-1, j, s);
                search(ans, node.nodes[index], board, visited, i, j+1, s);
                search(ans, node.nodes[index], board, visited, i, j-1, s);
                visited[i][j] = false;
            } 
        }
    }
}