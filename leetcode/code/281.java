public class ZigzagIterator {

    List<Integer> v1, v2;
    int p1, p2; 
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        p1 = p2 = 0;
    }

    public int next() {
        
        if (p1 >= v1.size()) 
            return v2.get(p2++);
        if (p2 >= v2.size())
            return v1.get(p1++);
        
        return p1==p2 ? v1.get(p1++):v2.get(p2++);
    }

    public boolean hasNext() {
        return p1<v1.size() || p2<v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */