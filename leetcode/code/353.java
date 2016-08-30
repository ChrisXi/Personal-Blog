public class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

    int w, h;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    Deque<int[]> pos = new LinkedList<int[]>();
    Queue<int[]> foods = new LinkedList<int[]>();
    public SnakeGame(int width, int height, int[][] food) {
        w = width;
        h = height;
        map.put(getPos(0,0), 1);
        pos.addFirst(new int[]{0,0});
        
        if (food.length > 0)
            map.put(getPos(food[0][0],food[0][1]), 2);
            
        for (int i=1; i<food.length; i++) 
            foods.offer(food[i]);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int x = direction.equals("L") ? -1:(direction.equals("R") ? 1:0);
        int y = direction.equals("U") ? -1:(direction.equals("D") ? 1:0);
        
        int[] head = pos.getFirst();
        int[] tail = pos.removeLast();
        int[] newHead = new int[]{head[0]+y, head[1]+x};
        map.remove(getPos(tail[0], tail[1]));
        
        if (newHead[0]<0 || newHead[0]>=h || newHead[1]<0 || newHead[1]>=w ||
            map.getOrDefault(getPos(newHead[0], newHead[1]), 0) == 1)
            return -1;
        
        if (map.getOrDefault(getPos(newHead[0], newHead[1]), 0) == 2) {
            pos.addLast(tail);
            map.put(getPos(tail[0],tail[1]), 1);
            
            if (foods.size() > 0) {
                int[] food = foods.poll();
                map.put(getPos(food[0],food[1]), 2);
            }
        }
        pos.addFirst(newHead);
        map.put(getPos(newHead[0],newHead[1]), 1);
        
        return pos.size()-1;
    }
    
    int getPos(int y, int x) {
        return y*w+x;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */