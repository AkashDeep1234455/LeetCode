class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k) return "0";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<num.length();i++){
            char curr = num.charAt(i);
            if(stack.isEmpty()) {
                stack.push(curr);
            }else{
                if(stack.peek()<=curr){
                    stack.push(curr);
                }else{
                    while (!stack.isEmpty()&&stack.peek()>curr&&k>0){
                        stack.pop();
                        k--;
                    }
                    stack.push(curr);
                }
            }
        }
        if(k!=0){
            while (k!=0){
                stack.pop();
                k--;
            }
        }
       StringBuilder runningString = new StringBuilder();
        while(!stack.isEmpty()){
            runningString.append(stack.pop());
        }
        StringBuilder out = runningString.reverse();
        while(out.length()!=1&&out.charAt(0)=='0'){
            out.deleteCharAt(0);
        }
        return out.toString();
    }
}