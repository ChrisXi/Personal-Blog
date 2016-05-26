class MyStack {
    
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    boolean q = true;
    
    // Push element x onto stack.
    public void push(int x) {
        if(q) {
            queue1.offer(x);
            while(!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
            q = false;
        } else {
            queue2.offer(x);
            while(!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            q = true;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(q) {
            queue2.poll();
        } else {
            queue1.poll();
        }
    }

    // Get the top element.
    public int top() {
        if(q) {
            return queue2.peek();
        } else {
            return queue1.peek();
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}