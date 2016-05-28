/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    List<Integer> list;
    int pos;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        pos = 0;
        list = new ArrayList<Integer>();
        addToLst(nestedList);
    }

    public void addToLst(List<NestedInteger> nestedList) {
        for(int i=0; i<nestedList.size(); i++) {
            if(nestedList.get(i).isInteger()) {
                this.list.add(nestedList.get(i).getInteger());
            } else {
                addToLst(nestedList.get(i).getList());
            }
        }
    }

    @Override
    public Integer next() {
        return this.list.get(pos++);
    }

    @Override
    public boolean hasNext() {
        return this.pos < this.list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */