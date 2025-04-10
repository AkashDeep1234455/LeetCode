class Solution {
    public boolean palindromeChecker(String s,int start,int end){
        if(s.length()==1) return true;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public void helper(String s,int start,List<List<String>> output,List<String> input){
        if(start==s.length()){
            output.add(new ArrayList<>(input));
            return;
        }
        for(int end=start+1;end<=s.length();end++){
            if(palindromeChecker(s,start,end-1)){
                input.add(s.substring(start,end));
                helper(s,end,output,input);
                input.remove(input.size()-1);
            }
        }

    }
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        helper(s,0,output,new ArrayList<>());
        return output;
    }
}