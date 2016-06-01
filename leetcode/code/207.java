public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
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
        
        for(int i=0; i<numCourses; i++) {
            if(!DFS(n1, n2, map, i, numCourses)) {
                return false;
            }
        }
        
        return true;
    }
    
    boolean DFS(int[] n1, int[] n2, HashMap<Integer, List<Integer>> map, int i, int num) {
        
        if(!map.containsKey(i))
            return true;
        
        if(n2[i] != 0) {
            return true;
        } else {
            if(n1[i] != 0) {
                return false;
            }
        }
        
        n1[i] = 1;
        List<Integer> lst = map.get(i);
        for(int j=0; j<lst.size(); j++) {
            int m = lst.get(j);
            if(!DFS(n1, n2, map, m, num)) {
                return false;
            }
        }
        n2[i] = 1;
        
        return true;
    }
    
    
}