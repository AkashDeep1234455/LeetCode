class Solution {
    public void help(List<List<Integer>> output,int nums[],int sum[],int target,List<Integer> input){
        if(sum[0]==target){
            LinkedList<Integer> entry = new LinkedList<>(input);
            Collections.sort(entry);
            if(!output.contains(entry)){
                output.add(new LinkedList<>(entry));
            }
            return;
        }
        if(sum[0]>target) return;
        for(int i=0;i<nums.length;i++){
            input.add(nums[i]);
            sum[0]+=nums[i];
            help(output,nums,sum,target,input);
            input.remove(input.size()-1);
            sum[0]-=nums[i];
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new LinkedList<>();
        help(output,candidates,new int[1],target,new LinkedList<>());
        return output;
    }
}