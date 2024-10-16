class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        helper(output,new ArrayList(),target,new int[1],candidates);
        return output;
    }
    private void helper(List<List<Integer>> output,List<Integer>input,int target,int currSum[],int candidates[]){
        if(currSum[0]==target){
            List<Integer> newList = new ArrayList<>(input);
            Collections.sort(newList);
            if(!output.contains(newList)){
                output.add(newList);
            }
            return;
        }
        if(currSum[0]>target) return;
        for(int i=0;i<candidates.length;i++){
                currSum[0]+=candidates[i];
                input.add(candidates[i]);
                helper(output,input,target,currSum,candidates);
                input.remove(input.size()-1);
                currSum[0]-=candidates[i];
        }
    }
}