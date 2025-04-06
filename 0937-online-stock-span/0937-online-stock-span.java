class Help{
    int price;
    int span;
    public Help(int val,int span){
        this.price = val;
        this.span = span;
    }
}

class StockSpanner {
    Stack<Help> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty()){
            Help curr = stack.pop();
            if(curr.price>price){
                stack.push(curr);
                break;
            }
            span+=curr.span;
        }
        stack.push(new Help(price,span));
        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */