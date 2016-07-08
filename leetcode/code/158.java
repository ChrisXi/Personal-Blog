/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    Queue<Character> left = new LinkedList<Character>();
    public int read(char[] buf, int n) {
        
        int sum = 0, count = 4;
        while(!left.isEmpty() && sum<n) {
            buf[sum++] = left.poll();
        }

        char[] temp = new char[4];
        while (count == 4 && sum < n){
            
            count = read4(temp);
            System.arraycopy(temp, 0, buf, sum, Math.min(count, n-sum));
            
            if (sum+count > n)
                for (int i=n-sum; i<count; i++)
                    left.offer(temp[i]);
                
            sum += Math.min(count, n-sum);
        } 
        
        return sum;
    }
}