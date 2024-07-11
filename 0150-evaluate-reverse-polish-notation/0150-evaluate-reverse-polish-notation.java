class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> token = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String curr = tokens[i];
            if(curr.equals("*")||curr.equals("+")||curr.equals("-")||curr.equals("/")){
                int first =Integer.parseInt(token.pop());
                int second =Integer.parseInt(token.pop());
                int calculatedValue=0;
                if(curr.equals("+")) calculatedValue = first+second;
                else if(curr.equals("-")) calculatedValue = second-first;
                else if(curr.equals("*")) calculatedValue = first*second;
                else if(curr.equals("/")) calculatedValue = second/first;
                token.push(Integer.toString(calculatedValue));
            }else{
                token.push(curr);
            }
        }
        return Integer.parseInt(token.pop());
    }
}