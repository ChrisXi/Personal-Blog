public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int len = numbers.length;
        
        for (int i=0; i<len; i++) {
            
            if (target - numbers[i] >= numbers[i]) {
                int j = getIndex(numbers, i+1, len-1, target-numbers[i]);
                if (j != -1) {
                    return new int[]{i+1, j+1};
                }
            }
        }
        
        return new int[]{-1,-1};
    }
    
    int getIndex(int[] numbers, int s, int e, int num) {
        while (s <= e) {
            int m = s+((e-s)>>1);
            if (num <= numbers[m]) {
                e = m-1;
            } else {
                s = m+1;
            }
        }
        
        return s<numbers.length&&numbers[s]==num ? s:-1;
    }
}