public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<int[]>();
        
        for (int i=0; i<buildings.length; i++) {
            heights.add(new int[]{buildings[i][0], -buildings[i][2]});
            heights.add(new int[]{buildings[i][1], buildings[i][2]});
        }
        
        Collections.sort(heights, (a, b)-> {
            if (a[0] == b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });
        
        List<int[]> ans = new ArrayList<int[]>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b) -> (b-a));
        int curHeight = 0;
        queue.offer(0);
        for (int[] h:heights) {
            
            if (h[1] < 0) {
                queue.offer(-h[1]);
            } else {
                queue.remove(h[1]);
            }
            
            if (curHeight != queue.peek()) {
                curHeight = queue.peek();
                ans.add(new int[]{h[0], curHeight});
            }
        }
        
        return ans;
    }
}