class Solution {
    public String minRemoveToMakeValid(String s) {
        int countOfCloseBracket = 0;
        char sArray[] = s.toCharArray();
        for(char c:sArray){
            if(c==')') countOfCloseBracket++;
        }
        Queue<Character> queue1 = new LinkedList<>();
        StringBuilder output = new StringBuilder();
        for(int i=0;i<sArray.length;i++){
            char curr = sArray[i];
            if(curr=='('){
               if(countOfCloseBracket>0){
                   queue1.add(curr);
                   countOfCloseBracket--;
               }else continue;
            }
            else if(curr==')'){
                if(!queue1.isEmpty()) {
                    queue1.poll();
                }
                else {
                    countOfCloseBracket--;
                    continue;
                }
            }
            output.append(curr);
        }
        return output.toString();
    }
}