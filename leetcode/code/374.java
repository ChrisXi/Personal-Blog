/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int max = n, min = 1;
        while(min <= max) {
            int ans = min+((max-min)>>1);
            if (guess(ans) == 1) 
            	min = ans+1;
            else if (guess(ans) == -1)
            	max = ans;
            else
                return ans;
        }

        return -1;
    }
}