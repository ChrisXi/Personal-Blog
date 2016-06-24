/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        
        if (map.containsKey(node.label)) 
            return map.get(node.label);
        
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        for (UndirectedGraphNode n: node.neighbors) {
            if (n.label == node.label)
                root.neighbors.add(root);
            else if (n.label > node.label) 
                root.neighbors.add(cloneGraph(n));
        }
        
        map.put(node.label, root);
        return root;
    }
}