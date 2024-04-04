class Solution {
    public int maxDepth(String s) {
        Stack<Character> store = new Stack<>();
        int maxDepth = 0;
        for(int i=0;i<s.length();i++){
            char currentry = s.charAt(i);
            if(currentry=='('){
                store.push(currentry);
            }else if(!store.isEmpty()&&currentry==')'){
                int depth = store.size();
                maxDepth  = Math.max(depth,maxDepth);
                store.pop();
            }
        }
        return maxDepth;
    }
}