class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> queue_open_bracket = new Stack<>();
        Stack<Integer> queue_special_sign = new Stack<>();
        char sArray[] = s.toCharArray();
        for(int i=0;i<sArray.length;i++){
            char curr = sArray[i];
            if(curr=='('){
                queue_open_bracket.push(i);
            }else if(curr=='*'){
                queue_special_sign.push(i);
            }else if(curr==')'){
                if(!queue_open_bracket.isEmpty()){
                    queue_open_bracket.pop();
                }else if(queue_open_bracket.isEmpty()&&!queue_special_sign.isEmpty()){
                    queue_special_sign.pop();
                }else{
                    return false;
                }
            }
        }
        if(queue_open_bracket.isEmpty()) return true;
        else{
           while(!queue_open_bracket.isEmpty()){
               if(queue_special_sign.isEmpty()) return false;
               if (queue_special_sign.peek()<queue_open_bracket.peek()) return false;
               queue_open_bracket.pop();
               queue_special_sign.pop();
           }
           return true;
        }
    }
}