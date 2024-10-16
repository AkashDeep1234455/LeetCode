class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>output = new ArrayList<>();
        helper(output,new StringBuilder(),n,0,0);
        return output;
    }
    private void helper(List<String>output,StringBuilder input,int n,int open,int close){
        if(input.length()==2*n){
            output.add(new StringBuilder(input.toString()).toString());
            return;
        }
        if(open<n){
            input.append('(');
            helper(output,input,n,open+1,close);
            input.deleteCharAt(input.length() - 1);
        }
        if(close<open){
            input.append(')');
            helper(output,input,n,open,close+1);
            input.deleteCharAt(input.length() - 1);
        }
    }
}