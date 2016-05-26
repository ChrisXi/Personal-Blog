class MyQueue {
    
    List<Integer> queue = new ArrayList<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        queue.add(0, x);    
    }

    // Removes the element from in front of queue.
    public void pop() {
        int size = queue.size();
        queue.remove(size-1);
    }

    // Get the front element.
    public int peek() {
        int size = queue.size();
        return queue.get(size-1);
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return queue.size() == 0;
    }
}