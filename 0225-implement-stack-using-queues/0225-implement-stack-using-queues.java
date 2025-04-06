class MyStack {

    Queue<Integer> first;
    Queue<Integer> second;
    int size;

    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }
    
    public void push(int x) {
        if((first.size() == 0 && second.size() == 0)||(second.size()==0)){
            first.add(x);
        }else{
            second.add(x);
        }
        size++;
    }
    
    public int pop() {
        size--;
        if(second.isEmpty()){
            while(first.size()!=1){
                second.add(first.poll());
            }
            return first.poll();
        }else{
             while(second.size()!=1){
                first.add(second.poll());
            }
            return second.poll();
        }
    }
    
    public int top() {
        if(second.isEmpty()){
            while(first.size()!=1){
                second.add(first.poll());
            }
            int out = first.peek();
            second.add(first.poll());
            return out;
        }else{
             while(second.size()!=1){
                first.add(second.poll());
            }
            int out = second.peek();
            first.add(second.poll());
            return out;
        }
    }
    
    public boolean empty() {
        return size==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */