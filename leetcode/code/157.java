/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        
        int sum = 0, count = 0;
        do {
            
            char[] temp = new char[4];
            count = read4(temp);
            
            System.arraycopy(temp, 0, buf, sum, Math.min(count, n-sum));
            sum += Math.min(count, n-sum);
            
        } while (count == 4 && sum < n);
        
        return sum;
    }
}