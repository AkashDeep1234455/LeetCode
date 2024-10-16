class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        helper(output,new ArrayList<>(),nums);
        return output;
    }
    private void helper(List<List<Integer>> output,List<Integer> input,int nums[]){
        if(input.size()==nums.length){
            output.add(new ArrayList<>(input));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!input.contains(nums[i])){
                input.add(nums[i]);
                helper(output,input,nums);
                input.remove(input.size()-1);
            }
        }
    }
}