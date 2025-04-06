class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;
    int size;
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
        size = 0;
    }
    
    public void push(int x) {
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        second.push(x);
        while(!second.isEmpty()){
                first.push(second.pop());
        }
        size++;
    }
    
    public int pop() {
        size-=1;
        return first.pop();
    }
    
    public int peek() {
        return first.peek();
    }
    
    public boolean empty() {
        return size==0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */