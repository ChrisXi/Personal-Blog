/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root);
        int childCount = 0;
        int num = 1;
        int dir = 0; //0: l->r, 1: r->l
        List<Integer> lst = new ArrayList<Integer>();
        while (!deque.isEmpty()) {
            TreeNode n = (dir==0 ? deque.pollFirst():deque.pollLast());
            TreeNode r = n.right, l = n.left;
            
            if (dir == 0) {
                if (l != null) { deque.addLast(l); childCount ++;}
                if (r != null) { deque.addLast(r); childCount ++;}
            } else {
                if (r != null) { deque.addFirst(r); childCount ++;}
                if (l != null) { deque.addFirst(l); childCount ++;}
            }
            
            lst.add(n.val);
            num --;
            if (num == 0) {
                num = childCount;
                childCount = 0;
                dir = 1 - dir;
                ans.add(lst);
                lst = new ArrayList<Integer>();
            }
        }
        
        return ans;
    }
}