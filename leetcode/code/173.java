/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    List<TreeNode> nums;

    public BSTIterator(TreeNode root) {
        
        nums = new ArrayList<TreeNode>();
        
        TreeNode node = root;
        while(node != null) {
            nums.add(node);
            node = node.left;
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        if(nums.size() != 0)
            return true;
        
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        
        TreeNode cur = nums.get(nums.size()-1);
        nums.remove(nums.size()-1);
        
        TreeNode node = cur.right;
        while(node != null) {
            nums.add(node);
            node = node.left;
        }
        
        return cur.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */