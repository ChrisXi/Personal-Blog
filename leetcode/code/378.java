class Data {
    int row, col;
    int val;
    Data(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Data> queue = new PriorityQueue<>((a,b)->(a.val-b.val));
        for (int i=0; i<matrix.length; i++) {
            queue.offer(new Data(i, 0, matrix[i][0]));
        }
        
        int count = 1;
        while (count < k) {
            Data data = queue.poll();
            count ++;
            while (count < k && data.col+1 >= matrix[0].length) {
                data = queue.poll();
                count ++;
            }
            if (data.col+1 < matrix[0].length)
                queue.offer(new Data(data.row, data.col+1, matrix[data.row][data.col+1]));
        }
        
        return queue.poll().val;
    }
}