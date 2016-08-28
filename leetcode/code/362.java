class Data {
    int time;
    int count;
    Data (int time, int count) {
        this.time = time;
        this.count = count;
    }
}

public class HitCounter {

    /** Initialize your data structure here. */
    Queue<Data> queue;
    int hitCount;
    public HitCounter() {
        queue = new LinkedList<Data>();
        hitCount = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        while(queue.size() > 0 && timestamp-queue.peek().time >= 300) {
            hitCount -= queue.poll().count;
        }
        
        if (queue.size() > 0 && queue.peek().time == timestamp) 
            queue.peek().count ++;
        else 
            queue.offer(new Data(timestamp, 1));
        
        hitCount ++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(queue.size() > 0 && timestamp-queue.peek().time >= 300) {
            hitCount -= queue.poll().count;
        }
        return hitCount;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */