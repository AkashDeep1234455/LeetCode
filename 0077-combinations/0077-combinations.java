class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new LinkedList<>();
        helper(n,k,output,new LinkedList<>(),1);
        return output;
    }
    public void helper(int n,int k,List<List<Integer>> output,List<Integer> input,int j){
        if(input.size()==k){
            output.add(new LinkedList<>(input));
            return;
        }
        for(int i=j;i<=n;i++){
            input.add(i);
            helper(n,k,output,input,i+1);
            input.removeLast();
        }


    }
}