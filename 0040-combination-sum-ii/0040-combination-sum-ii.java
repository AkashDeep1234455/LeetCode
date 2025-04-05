class Solution {
    public void help(int[]cand,List<List<Integer>> output,int index,int target,LinkedList<Integer> input,int []sum){
        if(sum[0]==target){
            output.add(new LinkedList<>(input));
            return;
        }
        if(sum[0]>target) return;
        for(int i=index;i<cand.length;i++){
            if(i>index&&cand[i]==cand[i-1]) continue; 
            input.add(cand[i]);
            sum[0]+=cand[i];
            help(cand,output,i+1,target,input,sum);
            sum[0]-=cand[i];
            input.remove(input.size()-1);
       }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new LinkedList<>();
        Arrays.sort(candidates);
        help(candidates,output,0,target,new LinkedList<>(),new int[1]);
        return output;
    }
}