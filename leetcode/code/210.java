class Node{
    int pos;
    int count;
    Node(int pos, int count) {
        this.pos = pos;
        this.count = count;
    }
}

class NodeComparator implements Comparator<Node> {
    public int compare(Node n1, Node n2) {
        return Integer.compare(n2.count, n1.count);
    }
}

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        for(int i=0; i<prerequisites.length; i++) {
            int m = prerequisites[i][0];
            int n = prerequisites[i][1]; //prerequisite
            
            if(map.containsKey(n)) {
                List<Integer> lst = map.get(n);
                lst.add(m);
            } else {
                List<Integer> lst = new ArrayList<Integer>();
                lst.add(m);
                map.put(n, lst);
            }
        }
        
        int[] n1 = new int[numCourses];
        int[] n2 = new int[numCourses];
        int[] ans = new int[numCourses];
        
        int count = 0;
        
        for(int i=0; i<numCourses; i++) {
            count = DFS(n1, n2, map, i, numCourses, count);
            if(count == -1) {
                return new int[0];
            }
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new NodeComparator());
        for(int i=0; i<numCourses; i++) {
            queue.offer(new Node(i, n2[i]));
        }
        
        int i=0;
        while(queue.size() != 0) {
            int pos = queue.poll().pos;
            ans[i++] = pos;
        }
        
        
        return ans;
    }
    
    int DFS(int[] n1, int[] n2, HashMap<Integer, List<Integer>> map, int i, int num, int count) {
        
        if(!map.containsKey(i))
            return count;
        
        if(n2[i] != 0) {
            return count;
        } else {
            if(n1[i] != 0) {
                return -1;
            }
        }
        
        n1[i] = count++;
        List<Integer> lst = map.get(i);
        for(int j=0; j<lst.size(); j++) {
            int m = lst.get(j);
            count = DFS(n1, n2, map, m, num, count);
            if(count == -1) {
                return -1;
            }
        }
        n2[i] = count++;
        
        return count;
    }
}