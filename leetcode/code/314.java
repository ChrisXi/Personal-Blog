/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Data {
    TreeNode node;
    int level;
    Data(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
public class Solution {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        
        int max = 0, min = 0;    
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Data> queue = new LinkedList<Data>();
        queue.offer(new Data(root, 0));
        while (queue.size() > 0) {
            Data data = queue.poll();
            
            min = Math.min(min, data.level);
            max = Math.max(max, data.level);
            
            List<Integer> lst = map.getOrDefault(data.level, new ArrayList<Integer>());
            lst.add(data.node.val);
            map.putIfAbsent(data.level, lst);
            
            if (data.node.left != null) queue.offer(new Data(data.node.left, data.level-1));
            if (data.node.right != null) queue.offer(new Data(data.node.right, data.level+1));
        }
        
        for (int i=min; i<=max; i++)
            ans.add(map.get(i));
        
        return ans;
    }
}