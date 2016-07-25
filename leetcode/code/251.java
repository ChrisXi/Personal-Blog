public class Vector2D implements Iterator<Integer> {

    int row, col;
    List<List<Integer>> vec;
        public Vector2D(List<List<Integer>> vec2d) {
        row = 0;
        col = 0;
        vec = vec2d;
        
        while(row < vec.size() && vec.get(row).size() == col) {
            col = 0;
            row ++;
        }
    }

    @Override
    public Integer next() {
        
        int ans = vec.get(row).get(col++);
        
        while(row < vec.size() && vec.get(row).size() == col) {
            col = 0;
            row ++;
        }
        
        return ans;
    }

    @Override
    public boolean hasNext() {
        
        return row<vec.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */