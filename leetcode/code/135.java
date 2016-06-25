public class Solution {
    public int candy(int[] ratings) {
        
        int len = ratings.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);
        
        for (int i=1; i<len; i++)
            candies[i] = (ratings[i]>ratings[i-1] ? candies[i-1]+1:candies[i]);
        
        int ans = 0;
        for (int i=len-1; i>=0; i--) {
            candies[i] = (i+1<len && candies[i]<=candies[i+1] && ratings[i]>ratings[i+1] ? candies[i+1]+1:candies[i]);
            ans += candies[i];
        }
        
        return ans;
    }
}

