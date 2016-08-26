public class MovingAverage {

    Queue<Integer> queue = new LinkedList<Integer>();
    int len = 0;
    double sum = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        len = size;
    }
    
    public double next(int val) {
       
        if (queue.size() == len)
            sum -= queue.poll();
        queue.offer(val);
        sum += val;
        return sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */