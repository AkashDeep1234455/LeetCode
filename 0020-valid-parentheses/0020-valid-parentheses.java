class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr=='('||curr=='{'||curr=='[') stack.push(curr);
            else{
                if(stack.isEmpty()) return false;
                if(curr==')'&&stack.pop()!='(') return false;
                else if(curr==']'&&stack.pop()!='[') return false;
                else if(curr=='}'&&stack.pop()!='{') return false;
            }
        }
        return stack.isEmpty();
    }
}