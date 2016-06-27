public class Solution {
    public int maximumGap(int[] nums) {
        
        int len = nums.length;
        if (len <= 1) return 0;
        
        int min = Math.min(nums[0], nums[1]);
        int max = Math.max(nums[0], nums[1]);
        for (int i=2; i<len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int size = max-min+1<len-1 ? 1:(max-min+1)/(len-1)+1;
        int[][] dis = new int[len-1][2];
        for (int i=0; i<len-1; i++) {
            dis[i][0] = Integer.MAX_VALUE;
            dis[i][1] = Integer.MIN_VALUE;
        }
        
        for (int i=0; i<len; i++) {
            int index = (nums[i]-min)/size;
            dis[index][0] = Math.min(dis[index][0], nums[i]);
            dis[index][1] = Math.max(dis[index][1], nums[i]);
        }
        
        int ans = dis[0][1]-dis[0][0];
        int pre = Math.max(dis[0][1], min);
        for (int i=1; i<len-1; i++) {
            ans = dis[i][0]==Integer.MAX_VALUE ? ans:Math.max(ans, dis[i][1]-dis[i][0]);
            ans = dis[i][0]==Integer.MAX_VALUE ? ans:Math.max(ans, dis[i][0]-pre);
            pre = dis[i][1]==Integer.MIN_VALUE ? pre:dis[i][1];
        }  
        return ans;
    }
}