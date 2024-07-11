class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> store = new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr!=')') store.push(curr);
            else{
                StringBuilder copyOutput = new StringBuilder();
                char input = store.pop();
                while(input!='('){
                    copyOutput.append(input);
                    input = store.pop();
                }
                for(int j=0;j<copyOutput.length();j++){
                    store.push(copyOutput.charAt(j));
                }
            }
        }
        StringBuilder copyOutput = new StringBuilder();
        while(!store.isEmpty()){
            char input = store.pop();
            copyOutput.append(input);
        }
        return copyOutput.reverse().toString();
    }
}