class Node {
    int visitied;
    int value;
    List<Node> neighbor;
    Node(int value) {
        this.value = value;
        visitied = 0;
        neighbor = new ArrayList<Node>();
    }
}
public class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i=0; i<edges.length; i++) {
            int v1 = edges[i][0], v2 = edges[i][1];
            Node n1 = map.getOrDefault(v1, new Node(v1));
            Node n2 = map.getOrDefault(v2, new Node(v2));
            n1.neighbor.add(n2);
            n2.neighbor.add(n1);
            map.put(v1, n1);
            map.put(v2, n2);
        }
        
        int ans = 0;
        for (int i=0; i<n; i++) {
            Node node = map.getOrDefault(i, new Node(i));
            if (node.visitied == 1)
                continue;
            search(node, map);
            ans ++;
        }
        
        return ans;
    }
    
    void search(Node n, HashMap<Integer, Node> map) {
        n.visitied = 1;
        for (int i=0; i<n.neighbor.size(); i++) {
            Node node = n.neighbor.get(i);
            if (node.visitied == 1)
                continue;
            search(node, map);
        }
    }
}